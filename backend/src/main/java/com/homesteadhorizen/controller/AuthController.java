package com.homesteadhorizen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homesteadhorizen.entity.CurrentHostSession;
import com.homesteadhorizen.entity.LoginDTO;
import com.homesteadhorizen.service.LoginService;

@RestController
@RequestMapping("/auth")
public class AuthController {
   @Autowired
   private LoginService loginserv;
   @PostMapping("/login")
   public ResponseEntity<CurrentHostSession> login(@RequestBody LoginDTO dto){
	   return new ResponseEntity<CurrentHostSession>(loginserv.login(dto), HttpStatus.OK);
   }
   @PostMapping("/logout")
   public ResponseEntity<String> logout(@RequestParam("uuid") String key){
	   return new ResponseEntity<String>(loginserv.logOutFromAccount(key), HttpStatus.OK);
   }
}
