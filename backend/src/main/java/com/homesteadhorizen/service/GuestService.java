package com.homesteadhorizen.service;

import java.util.List;

import com.homesteadhorizen.entity.Guest;

public interface GuestService {
  public Guest creategust(Guest guest);
  public Guest updateGuest(Guest guest);
  public List<Guest> findAllGuest();
  public Guest findByEmail(String email);
  public Guest deleteGuest(String email);
}
