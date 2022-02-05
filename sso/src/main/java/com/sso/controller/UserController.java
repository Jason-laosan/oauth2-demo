package com.sso.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laosan
 * Date: 2022/2/5
 * Time: 18:16
 * Describe:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "getCurrentUser")
    public Object getCurrentUser(Authentication authentication){
        return authentication;
    }
}
