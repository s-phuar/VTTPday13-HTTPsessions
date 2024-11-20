package VTTPday13.exercise.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class Tasks {

    private String name;
    private String priority;
    private LocalDate dueDate;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPriority() {return priority;}
    public void setPriority(String priority) {this.priority = priority;}

    public LocalDate getDueDate() {return dueDate;}
    public void setDueDate(LocalDate dueDate) {this.dueDate = dueDate;}

    @Override
    public String toString(){
        return "Task: " + name + ", Priority: " + priority + ", Due Date: " + dueDate;
    }
    
}
