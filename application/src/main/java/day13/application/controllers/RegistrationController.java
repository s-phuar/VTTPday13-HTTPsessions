package day13.application.controllers;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import day13.application.models.Registration;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    public static final String REG_LIST = "regList";

    private String prevName = "";
 
    // POST /registration
    @PostMapping("/obj")
    public String postRegistrationObj(
          @Valid @ModelAttribute("reg") Registration registration, //new instance of Registration object is instatiated everytime we POST in html
          // BindingResult must follow @Valid immediately
          BindingResult bindings, Model model, HttpSession sess) {
 
       System.out.printf("---- bindings: %b\n", bindings.hasErrors());
       System.out.printf("---- registration: %s\n", registration); //prints the toString method in Registration class 
 
       //if there are errors in validation, show landing page immediately with error prompt
       if (bindings.hasErrors()) 
          return "index";
 
       if ("fred".equals(registration.getName().toLowerCase())) {
          FieldError err = new FieldError("reg", "name", "You cannot use the name fred");
          bindings.addError(err);
 
          ObjectError objErr = new ObjectError("globalError", "error 1");
          bindings.addError(objErr);
          objErr = new ObjectError("globalError", "error 2");
          bindings.addError(objErr);
          return "index";
       }
 
       // Overarching - Check if the session has a reglist
       // retrieve registration list from the session (if it exists)
       List<Registration> regList = (List<Registration>)sess.getAttribute(REG_LIST);
 
       if (regList == null) {
          // If new session then reglist is null
          // Initialize session by creating a list
          regList = new LinkedList<>();
          // Add to the session
          sess.setAttribute(REG_LIST, regList); //store freshly createted regList in the session
       }
 
       regList.add(registration);
 
       model.addAttribute("email", "fred@gmail.com"); //hardcoded to fred@gmail.com, for the 1st iteration of the 'registered' email check example
 
       model.addAttribute("reg", registration); //for 2nd and 3rd of the email checkers in 'registered'
       model.addAttribute("regList", regList);
 
       return "registered";
    }
 
    // POST /registration
    @PostMapping
    public String postRegistration(@RequestBody MultiValueMap<String, String> form,
          @RequestBody String rawBody,
          Model model) {
 
       Registration reg = new Registration();
       reg.setName(form.getFirst("name"));
 
       System.out.printf("---- form: %s\n", form);
       System.out.printf("---- rawBody: %s\n", rawBody);
       System.out.printf("---- prevName: %s\n", prevName);
 
       model.addAttribute("prevName", prevName);
 
       prevName = reg.getName();
 
       model.addAttribute("reg", reg);
 
       return "registered";
 
    }
       
}
