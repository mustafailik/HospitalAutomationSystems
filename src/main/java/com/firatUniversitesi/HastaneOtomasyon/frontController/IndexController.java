package com.firatUniversitesi.HastaneOtomasyon.frontController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller

public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/service")
    public String service(){
        return "service";
    }
    @GetMapping("/team")
    public String team(){
        return "team";
    }
    @GetMapping("/appointment")
    public String appointment(){
        return "appointment";
    }
    @GetMapping("/appointments")
    public String appointments(){
        return "appointments";
    }
    @GetMapping("/appointmentsfordoctor")
    public String appointmentsForDoctor(){
        return "appointmentsfordoctor";
    }
    @GetMapping("/appointmentactivity")
    public String appointmentActivity(){
        return "appointmentactivity";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
    @GetMapping("/loginDoctor")
    public String loginDoctor(){
        return "loginDoctor";
    }
    @GetMapping("/loginPatient")
    public String loginPatient(){
        return "loginPatient";
    }
    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }
    @GetMapping("/testimonial")
    public String testimonial(){
        return "testimonial";
    }
    @GetMapping("/prescription")
    public String prescription(){
        return "prescription";
    }
    @GetMapping("/report")
    public String report(){
        return "report";
    }
    @GetMapping("/finding")
    public String finding(){
        return "finding";
    }
    @GetMapping("/loggedInPagePatient")
    public String loggedInPagePatient(){
        return "loggedInPagePatient";
    }

    @GetMapping("/loggedInPageDoctor")
    public String loggedInPageDoctor(){
        return "loggedInPageDoctor";
    }

    @GetMapping("/registerDoctor")
    public String registerDoctor(){
        return "registerDoctor";
    }
}
