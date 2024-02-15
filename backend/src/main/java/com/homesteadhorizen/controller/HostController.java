package com.homesteadhorizen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homesteadhorizen.entity.Host;
import com.homesteadhorizen.service.HostService;

@RestController
@RequestMapping("/host")
public class HostController {
   @Autowired
   private HostService hostservice;
   @PostMapping("/addhost")
   public ResponseEntity<Host> createHost(@RequestBody Host host){
	   Host h=hostservice.createHost(host);
	   return new ResponseEntity<Host>(h, HttpStatus.CREATED);
   }
   @GetMapping("/getAllHost")
   public ResponseEntity<List<Host>> viewAllhost(){
	   List<Host> list= hostservice.viewHostList();
	   return new ResponseEntity<List<Host>>(list, HttpStatus.OK);
   }
   @GetMapping("/getByemail")
   public ResponseEntity<Host> viewHostByEmail(@RequestParam ("email") String email){
	   Host h= hostservice.getHostByEmail(email);
	   return new ResponseEntity<Host>(h, HttpStatus.OK);
   }
   @PatchMapping("/updatehost")
   public ResponseEntity<Host> updateHost(@RequestBody Host host){
	   Host h= hostservice.updateHost(host);
	   return new ResponseEntity<Host>(h, HttpStatus.ACCEPTED);
	   
   }
   @DeleteMapping("/delete")
   public ResponseEntity<Host> deleteHost(@RequestParam ("email") String email){
	   Host h= hostservice.deleteHost(email);
	   return new ResponseEntity<Host>(h, HttpStatus.OK);
   }
}
