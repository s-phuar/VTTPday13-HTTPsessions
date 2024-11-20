package day13.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import day13.application.models.Registration;


//designates our landing page, in this case it is index

@Controller
@RequestMapping(path={"/", "index.html"})
public class IndexController {
    @GetMapping
   public String getIndex(Model model) {

      model.addAttribute("reg", new Registration());

      return "index";
   }
}
