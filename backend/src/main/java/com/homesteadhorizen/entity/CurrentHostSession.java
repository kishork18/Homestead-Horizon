package com.homesteadhorizen.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CurrentHostSession {
	@Id
	@Column(unique = true)
	private String userId;
	private String type;
	private String uuid;
	private LocalDateTime localDateTime;
}
