package com.homesteadhorizen.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Host {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    @Column(unique = true, nullable=false)
	    private String email;
	    private String password;
	    private double totalEarnings;
	    private String about;
	    @Enumerated(EnumType.STRING)
	    private HostStatus hostStatus;
	    
	    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
	    private List<Property> properties;

	    

	    private LocalDate hostingSince;
}
