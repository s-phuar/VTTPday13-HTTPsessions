package VTTPday13.exercise.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import VTTPday13.exercise.models.Tasks;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping
public class SaveController {
    @PostMapping("/exit")
    public String postExit(HttpSession sess, Model model){

        //retrieve and print out session's task list
        List<Tasks> taskList = (List<Tasks>)sess.getAttribute(TaskController.TASK_LIST);
        System.out.printf(">>>task list: %s\n", taskList);

        //close session
        sess.invalidate();

        model.addAttribute("Tasks", new Tasks());
        model.addAttribute("taskList", new ArrayList<>());


        return "index";
    }


}
