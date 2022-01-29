package com.yang.springsecuritys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang
 * @className UserController
 * @description TODO
 * @date 2021/12/16 9:36
 * @Version 1.0
 */
@RestController
@RequestMapping("/user/api")
public class UserController {

    @GetMapping("hello")
    public String hello(){
        return "hello user";
    }
}
