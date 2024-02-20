package com.homesteadhorizen.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homesteadhorizen.entity.Guest;
import com.homesteadhorizen.repository.GuestRepo;
import com.homesteadhorizen.service.GuestService;



@Service

public class GuestServiceImpl implements GuestService {
	private static final Logger logger = LoggerFactory.getLogger(GuestServiceImpl.class);

	@Autowired
	private GuestRepo guestrepo;

	@Override
	public Guest creategust(Guest guest) {
		try {
			guest.setBookings(new ArrayList<>());
			logger.debug("provided email is" + guest.getEmail());
			return guestrepo.save(guest);
		} catch (Exception e) {
			logger.error("Error occurred while creating guest: {}", e.getMessage());

			throw e;
		}
	}

	@Override
	public Guest updateGuest(Guest guest) {
		try {
			Optional<Guest> optionalGuest = guestrepo.findByEmail(guest.getEmail());
			if (optionalGuest.isPresent()) {
				Guest existingGuest = optionalGuest.get();
				existingGuest.setBio(guest.getBio());
				existingGuest.setName(guest.getName());
				return guestrepo.save(existingGuest);
			} else {
				logger.warn("Guest with email {} not found", guest.getEmail());
				return null;
			}
		} catch (Exception e) {
			logger.error("Error occurred while updating guest: {}", e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Guest> findAllGuest() {
		// TODO Auto-generated method stub
		return guestrepo.findAll();
	}

	@Override
	public Guest findByEmail(String email) {
		Guest gst = guestrepo.findByEmail(email).get();
		return gst;
	}

	@Override
	public Guest deleteGuest(String email) {

		Guest gst = guestrepo.findByEmail(email).orElseThrow(() -> new RuntimeException("Guest not found"));

		gst.getBookings().size();

		guestrepo.delete(gst);

		return gst;
	}

}
