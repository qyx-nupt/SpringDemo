package com.qyx.springbootdemoexceptionhandler.controller;

import com.qyx.springbootdemoexceptionhandler.exception.PageException;
import com.qyx.springbootdemoexceptionhandler.model.Result;
import com.qyx.springbootdemoexceptionhandler.model.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello word";
    }

    @GetMapping("/json")
    @ResponseBody
    public Result jsonError(){
        String[] arr = {};
        for (int i = 0; i <= arr.length ; i++) {
            System.out.println(arr[i]);
        }
        return new Result();
    }
    @GetMapping("/page")
    public ModelAndView pageError(){
        throw new PageException(Status.VISIT_ERROR);
    }
}
