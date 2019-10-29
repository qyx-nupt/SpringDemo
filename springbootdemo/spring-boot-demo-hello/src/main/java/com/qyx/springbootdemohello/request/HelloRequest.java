package com.qyx.springbootdemohello.request;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRequest {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who){
        if(StrUtil.isBlank(who)){
            who = "word";
        }
        return  StrUtil.format("hello, {}",who);
    }
}
