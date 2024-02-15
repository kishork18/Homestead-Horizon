package com.homesteadhorizen.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Property {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private double rentpernight;
	    private String location;
	    private Set<String> img;
	    @Enumerated(EnumType.STRING)
	    private PropertyType propertyType;

	    @ManyToOne
	    @JoinColumn(name = "host_id")
	    private Host host;

	    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
	    private List<Booking> bookings;
}
