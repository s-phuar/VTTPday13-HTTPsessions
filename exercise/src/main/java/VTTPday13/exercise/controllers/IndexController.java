package VTTPday13.exercise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import VTTPday13.exercise.models.Tasks;

@Controller
@RequestMapping(path={"/", "index.html"})
public class IndexController {
    @GetMapping
    public String getIndex(Model model){

        model.addAttribute("Tasks", new Tasks());
        return "index";

    }
}
