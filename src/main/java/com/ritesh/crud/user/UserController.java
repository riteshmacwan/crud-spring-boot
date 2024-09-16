package com.ritesh.crud.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String helloWorld(){
        return  "Hello From Ritesh!!";
    }

}
