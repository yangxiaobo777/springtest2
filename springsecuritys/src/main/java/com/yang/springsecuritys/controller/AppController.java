package com.yang.springsecuritys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang
 * @className AppController
 * @description TODO
 * @date 2021/12/16 9:36
 * @Version 1.0
 */
@RestController
@RequestMapping("/app/api")
public class AppController {

    @GetMapping("hello")
    public String hello(){
        return "hello app";
    }
}
