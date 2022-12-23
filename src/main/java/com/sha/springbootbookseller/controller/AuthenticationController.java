package com.sha.springbootbookseller.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.service.IAuthenticationService;
import com.sha.springbootbookseller.service.IUserService;

import java.awt.Image;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sa
 * @date 3.07.2021
 * @time 19:47
 */
@RestController
@RequestMapping("api/authentication")//pre-path
public class AuthenticationController
{
    @Autowired
    private IAuthenticationService authenticationService;


    @Autowired
    private IUserService userService;

    @PostMapping("sign-up") //api/authentication/sign-up
    public ResponseEntity<?> signUp(@RequestParam(required = false,value = "file") MultipartFile file,@RequestParam String user) throws IOException
    {
    	ObjectMapper mapper=new ObjectMapper();
    	User user2=mapper.readValue(user, User.class);
    	
      
        if (userService.findByUsername(user2.getUsername()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user2,file), HttpStatus.CREATED);
    	
    }
    

    @PostMapping("sign-in")//api/authentication/sign-in
    public ResponseEntity<?> signIn(@RequestBody User user)
    {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }
}
