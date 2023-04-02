package com.spring.home_work.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class TestController {

    @GetMapping("/test")
    public ModelAndView getText(@RequestParam(defaultValue = "test") String text) {
        ModelAndView result = new ModelAndView("test");
        result.addObject("value", text);
        return result;
    }

    @PostMapping("/test")
    public ModelAndView setText(@RequestParam(defaultValue = "test") String text) {
        ModelAndView result = new ModelAndView("test");
        result.addObject("value", text);
        return result;
    }
}
