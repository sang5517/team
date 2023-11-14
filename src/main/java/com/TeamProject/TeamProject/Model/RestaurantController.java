package com.TeamProject.TeamProject.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestaurantController {
    @GetMapping("/list")
    public String list(){
        return "photo-detail";
    }
}
