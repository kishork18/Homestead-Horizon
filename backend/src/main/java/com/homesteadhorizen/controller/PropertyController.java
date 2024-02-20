package com.homesteadhorizen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homesteadhorizen.entity.CurrentHostSession;
import com.homesteadhorizen.entity.Host;
import com.homesteadhorizen.entity.Property;
import com.homesteadhorizen.repository.HostRepo;
import com.homesteadhorizen.repository.SessionRepo;
import com.homesteadhorizen.service.PropertyService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/property")
@Slf4j
public class PropertyController {
	private PropertyService ps;
	private SessionRepo sr;
	private HostRepo hs;

	public PropertyController(PropertyService ps, SessionRepo sr, HostRepo hs) {
		super();
		this.ps = ps;
		this.sr = sr;
		this.hs = hs;
	}

	@PostMapping("/addproperty/{uuid}")
	public ResponseEntity<Property> addProperty(@PathVariable("uuid") String uuid, @RequestBody Property prop) {
		CurrentHostSession chs = sr.findByUuid(uuid);
		Optional<Host> hostop = hs.findByEmail(chs.getUserId());
		log.debug("inside controller of property controller");
		if (hostop.isPresent()) {
			prop.setHost(hostop.get());
		}
		Property props = ps.addProperty(prop);
		return new ResponseEntity<>(props, HttpStatus.OK);
	}
	@PatchMapping("/update")
	ResponseEntity<Property> updatehandler(@RequestBody Property prop){
		Property props= ps.updateProp(prop);
		return new ResponseEntity<Property>(props, HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Property>> findallhandller() {
		List<Property> list= ps.findAll();
		return new ResponseEntity<List<Property>>(list, HttpStatus.OK);
	}
	@GetMapping("/getbyhost/{uuid}")
	public ResponseEntity<List<Property>> findbyhosthandller(@PathVariable("uuid") String uuid) {
		CurrentHostSession chs = sr.findByUuid(uuid);
		Optional<Host> hostop = hs.findByEmail(chs.getUserId());
		log.debug("inside controller of property controller");

		List<Property> list= ps.findByHost(hostop.get());
		return new ResponseEntity<List<Property>>(list, HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<Property> deleteHandler(@RequestParam long id){
		Property prop= ps.delete(id);
		return new ResponseEntity<Property>(prop, HttpStatus.OK);
	}
	
	
}
