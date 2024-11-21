package VTTPday13.workshop.controller;


import java.util.LinkedList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

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
import VTTPday13.workshop.models.Login;
import io.netty.handler.codec.http.HttpScheme;

@Controller
@RequestMapping
public class LoginController {

    @PostMapping("/secret")
    public String getLogin(
        @ModelAttribute("Login") Login Login, //binds the form to the login object
        Model model,
        HttpSession sess){

            //check whether session has a Login object, if not create one
            // ******** note that the "Login" object passed via the @ModelAttribute is NOT the same instance as the one sess.getAttribute is trying to access
            if(sess.getAttribute("Login") == null){
                sess.setAttribute("Login", new Login());
            }

            //access the Login object in the session
            Login sessionLogin = (Login)sess.getAttribute("Login");

            String loginName  = Login.getName(); //do NOT update session with this, we do not want form name and password to persist across the session
            String loginPassword  = Login.getPassword();
            int counter  = sessionLogin.getAttempts(); //grab session's instance of Login's counter
            String captcha = Login.getCaptcha();



            //fail to login
            if ((!loginName.equals("Samuel") || !loginPassword.equals("abc")) && counter <= 2 ){
                //sessionLogin.trackFails() updates the session's instance of Login, across multiple attempts within the same session as long as the session remains active
                sessionLogin.trackFails();

                model.addAttribute("attempts", sessionLogin.getAttempts()); //return to index with this data
                return "index";
            }else if((!loginName.equals("Samuel") || !loginPassword.equals("abc")) && counter > 2){
                if(captcha == null || !captcha.equals("3680")){
                    sessionLogin.reset(); //reset counter
                    return "locked";
                }
            }else if (loginName.equals("Samuel") && loginPassword.equals("abc") && (captcha == null || captcha.equals("3680"))) {
                sessionLogin.reset(); // Reset counter after successful login
                model.addAttribute("name", loginName); // Pass name to the view
                return "secret"; // login whenever name/pass/captcha correct, captcha is optional. 
            }
            else{ //logged in

                sessionLogin.reset(); //reset counter
                return "locked";
            }

            return "index";
    }
    
}
