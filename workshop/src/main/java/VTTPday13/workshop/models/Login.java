package VTTPday13.workshop.models;

public class Login {
    private String name;
    private String password;
    private int attempts = 0;
    private String captcha;

    public String getCaptcha() {return captcha;}
    public void setCaptcha(String captcha) {this.captcha = captcha;}
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public int getAttempts() {return attempts;}
    public void setAttempts(int attempts) {this.attempts = attempts;}


    public void trackFails(){
        attempts ++;
    }

    public void reset(){
        attempts = 0;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Password: " + password;
    }

    
}
