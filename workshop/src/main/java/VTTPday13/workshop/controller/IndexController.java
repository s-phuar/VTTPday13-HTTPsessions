package VTTPday13.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import VTTPday13.workshop.models.Login;

@Controller
@RequestMapping(path={"/", "index.html", "secret"})
public class IndexController {
    @GetMapping
    public String getIndex(Model model){

        model.addAttribute("Login", new Login());

        return "index";
    }

    
}
