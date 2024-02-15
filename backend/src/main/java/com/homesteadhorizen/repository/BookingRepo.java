package com.homesteadhorizen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homesteadhorizen.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}
