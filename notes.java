package day13workshopssf;

public class notes {
    
}

// content type specifies encoding of the form data(payload), browser recognises that content type and reads accordingly
//binding form data dynamically to objects
    //handler instead of using multivaluemap, it uses the object
    //using getter setters to access object information to be used in dynamic templates
    //field used for input fields (calls the setName setter)
    //text used for displaying output (calls the getName getter)

//if we specify index.html in the path for the controller, we look for the index.html in the template section, we no longer default to static index.html

//@ModelAttribute for binding data to the object
//@Valid for validating the object
//Recall request param binded data must have same name as variable, if not we must explicitly provide the parameter name see ssf11 pg24
//BindingResult for printing true/false on whether theres errors. BindingResult must follow @Valid immediately


//create your own error message with FieldError err = new FieldError(obj,name,msg);
    //bindings.addError(err);

//session maintenance
    //when storing info in webapp, never put a variable in the code. If not subsequent clients can see older clients' data
    //session stores data inside the webapp without cross contaminating across clients browser