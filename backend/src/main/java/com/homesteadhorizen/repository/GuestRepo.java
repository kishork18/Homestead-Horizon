package com.homesteadhorizen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homesteadhorizen.entity.Guest;

public interface GuestRepo extends JpaRepository<Guest, Long> {
   public Optional<Guest> findByEmail(String email);
}
