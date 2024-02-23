package com.ms_perfume.ms_perfume.controller;

import com.ms_perfume.ms_perfume.dto.LoginResponse;
import com.ms_perfume.ms_perfume.entity.Users;
import com.ms_perfume.ms_perfume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.io.StringReader;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody Users user) {
        return userService.userLogin(user);
//        return  loginResponse;
    }


}
