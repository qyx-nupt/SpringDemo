package com.qyx.springbootdemoproperties.controller;

import cn.hutool.core.lang.Dict;
import com.qyx.springbootdemoproperties.property.ApplicationProperty;
import com.qyx.springbootdemoproperties.property.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {
    @Autowired
    private ApplicationProperty applicationProperty;
    @Autowired
    private DeveloperProperty developerProperty;

    public PropertyController() {
    }

    @GetMapping("/property")
    public Dict getDict(){
        return  Dict.create().set("applicationProperty",applicationProperty).set("developerProperty",developerProperty);
    }


}
