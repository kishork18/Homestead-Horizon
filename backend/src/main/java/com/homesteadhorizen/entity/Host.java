package com.homesteadhorizen.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
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
	    
	    @Enumerated(EnumType.STRING)
	    private HostStatus hostStatus;

	    private String location;

	    @Enumerated(EnumType.STRING)
	    private PropertyType propertyType;

	    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
	    private List<Property> properties;

	    private String about;

	    private LocalDate hostingSince;
}
