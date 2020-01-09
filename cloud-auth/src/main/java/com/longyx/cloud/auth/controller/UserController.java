package com.longyx.cloud.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


/**
 * @author Administrator
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
