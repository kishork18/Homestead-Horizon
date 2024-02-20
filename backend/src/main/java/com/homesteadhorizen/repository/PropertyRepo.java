package com.homesteadhorizen.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homesteadhorizen.entity.Host;
import com.homesteadhorizen.entity.Property;

public interface PropertyRepo extends JpaRepository<Property, Long> {
  Optional<List<Property>> findByHost(Host host);
}
