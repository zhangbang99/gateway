package com.cloud.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbb
 * @description
 * @date 2024/2/23 10:42
 */
@RestController
public class TestController {

    @GetMapping("")
    public String test(){
        return "user";
    }
}
