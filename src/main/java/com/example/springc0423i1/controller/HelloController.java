package com.example.springc0423i1.controller;

import com.example.springc0423i1.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/api")
public class HelloController {

    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{message}")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView helloWorld(@PathVariable String message){
        ModelAndView view = new ModelAndView("index");
        view.addObject("message", message);
        return view;// req.getDispatcher('index').forward(req,resp)
    }
    @PostMapping("/hello")
    public String demo(){
        return "hello";
    }


}
