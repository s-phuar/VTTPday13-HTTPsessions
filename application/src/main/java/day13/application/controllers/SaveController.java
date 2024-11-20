package day13.application.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import day13.application.models.Registration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping
public class SaveController {
    @PostMapping("/exit")
    public String postExit(HttpSession sess, Model model) {
        //TODO: process POST request

        //retrieve the session's REG_LIST and print it out
        List<Registration> regList = (List<Registration>)sess.getAttribute(RegistrationController.REG_LIST);
        System.out.printf(">>> reglist: %s\n", regList);
 
        // Destroy the session, removes all atrributes stored in the session (removes regList)
        sess.invalidate();
 
        model.addAttribute("reg", new Registration());
        
        return "index";
    }
}
