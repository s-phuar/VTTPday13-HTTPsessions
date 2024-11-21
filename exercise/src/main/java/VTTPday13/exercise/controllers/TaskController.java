package VTTPday13.exercise.controllers;

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
import VTTPday13.exercise.models.Tasks;
import io.netty.handler.codec.http.HttpScheme;


@Controller
@RequestMapping(path={"/tasks"})
public class TaskController {
    public static final String TASK_LIST = "taskList";


    @PostMapping
    public String getTask(
        @ModelAttribute("Tasks") Tasks Tasks,
        Model model,
        HttpSession sess ){

        List<Tasks> taskList  = (List<Tasks>)sess.getAttribute(TASK_LIST);
        if(taskList == null){
            taskList = new LinkedList<>();
            sess.setAttribute(TASK_LIST, taskList);
        }

        taskList.add(Tasks);

        model.addAttribute("Tasks", new Tasks()); //lets us send a fresh object to index, if not name/prio is pre-filled with prior attempts
        model.addAttribute("taskList", taskList);


        return "index";

    }
}
