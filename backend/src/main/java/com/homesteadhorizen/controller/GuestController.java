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
import org.springframework.web.bind.annotation.RestController;

import com.homesteadhorizen.entity.Guest;
import com.homesteadhorizen.service.GuestService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/guests")
@Slf4j
public class GuestController {
	@Autowired
	private GuestService gs;

	@PostMapping("/createguest")
	public ResponseEntity<Guest> addGuest(@RequestBody Guest guest) {
		Guest gst = gs.creategust(guest);
		return new ResponseEntity<Guest>(gst, HttpStatus.CREATED);
	}

	@PatchMapping("/update")
	public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest) {
		Guest gst = gs.updateGuest(guest);
		return new ResponseEntity<Guest>(gst, HttpStatus.OK);
	}

	@GetMapping("/getAllGuest")
	public ResponseEntity<List<Guest>> findAllGuest() {
		List<Guest> list = gs.findAllGuest();
		return new ResponseEntity<List<Guest>>(list, HttpStatus.OK);
	}

	@GetMapping("/getGuestbyemail")
	public ResponseEntity<Guest> findbyemail(@RequestParam("email") String email) {
		Guest gst = gs.findByEmail(email);

		return new ResponseEntity<Guest>(gst, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Guest> deleteGuest(@RequestParam("email") String email) {
		Guest gst = gs.deleteGuest(email);
		log.info("inside the controller");

		return new ResponseEntity<Guest>(gst, HttpStatus.OK);
	}

}
