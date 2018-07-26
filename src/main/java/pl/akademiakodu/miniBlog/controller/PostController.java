package pl.akademiakodu.miniBlog.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

public class PostController {
    @GetMapping("/add")
    public String add(ModelMap modelMap){
        return "add";
    }
}
