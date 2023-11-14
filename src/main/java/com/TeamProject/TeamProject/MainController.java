package com.TeamProject.TeamProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
    @RequestMapping("/main")
    @ResponseBody
    public String main(){
        return "main";
    }

}
