package Zoul.lalaina.BackEnd.controller;

import Zoul.lalaina.BackEnd.dto.LoginDto;
import Zoul.lalaina.BackEnd.dto.UserDto;
import Zoul.lalaina.BackEnd.response.LoginResponse;
import Zoul.lalaina.BackEnd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping
    public String register(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){
        LoginResponse loginResponse = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);

    }
    @GetMapping
    public ResponseEntity<?> loginUser(){
        LoginResponse loginResponse = userService.loginUser();
        return ResponseEntity.ok(loginResponse);

    }
    @GetMapping("logout")
    public ResponseEntity <?> logoutUser(){
        LoginResponse loginResponse = userService.logoutUser();
        return ResponseEntity.ok(loginResponse);
    }

}
