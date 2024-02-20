package com.homesteadhorizen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homesteadhorizen.entity.CurrentHostSession;

public interface SessionRepo extends JpaRepository<CurrentHostSession, String> {
     public CurrentHostSession findByUuid(String uuid);
}
