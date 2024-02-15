package com.homesteadhorizen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homesteadhorizen.entity.Property;

public interface PropertyRepo extends JpaRepository<Property, Long> {

}
