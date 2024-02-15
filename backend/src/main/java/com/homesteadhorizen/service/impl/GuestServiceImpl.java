package com.homesteadhorizen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homesteadhorizen.entity.Guest;
import com.homesteadhorizen.repository.GuestRepo;
import com.homesteadhorizen.service.GuestService;
 @Service
public class GuestServiceImpl implements GuestService {
	@Autowired
    private GuestRepo guestrepo;
	@Override
	public Guest creategust(Guest guest) {
		guest.setBookings(new ArrayList<>());
		return guestrepo.save(guest);
	}

	@Override
	public Guest updateGuest(Guest guest) {
		 Guest gst= guestrepo.findByEmail(guest.getEmail()).get();
		 gst.setBio(guest.getBio());
		 gst.setName(guest.getName());
		return guestrepo.save(gst);
	}

	@Override
	public List<Guest> findAllGuest() {
		// TODO Auto-generated method stub
		return guestrepo.findAll();
	}

	@Override
	public Guest findByEmail(String email) {
		Guest gst= guestrepo.findByEmail(email).get();
		return gst;
	}

	@Override
	public Guest deleteGuest(String email) {
		 Guest gst= guestrepo.findByEmail(email).get();
		 guestrepo.delete(gst);
		return gst;
	}

}
