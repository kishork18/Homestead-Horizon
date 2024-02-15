package com.homesteadhorizen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homesteadhorizen.entity.Host;

public interface HostRepo extends JpaRepository<Host, Long> {
  public Optional<Host> findByEmail(String email);
}
