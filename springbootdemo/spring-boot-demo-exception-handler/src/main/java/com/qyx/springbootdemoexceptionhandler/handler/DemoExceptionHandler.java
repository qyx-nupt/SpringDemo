package com.qyx.springbootdemoexceptionhandler.handler;

import com.qyx.springbootdemoexceptionhandler.exception.PageException;
import com.qyx.springbootdemoexceptionhandler.model.Result;
import com.qyx.springbootdemoexceptionhandler.model.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class DemoExceptionHandler {
    private static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    protected Result JsonHandle(Exception ex){
        log.error("return error json:" + ex);
        return Result.error(Status.VISIT_ERROR);
    }

    @ExceptionHandler(PageException.class)
    protected ModelAndView PageHandle(Exception ex){
        log.error("return error page");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message",ex.getMessage());
        mv.setViewName(DEFAULT_ERROR_VIEW);
        return mv;
    }
}
