package com.homesteadhorizen.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
	    @ElementCollection
	    @Column(length = 1000)
	    private Set<String> img;
	    @Enumerated(EnumType.STRING)
	    private PropertyType propertyType;
	    @JsonIgnore
	    @ManyToOne
	    @JoinColumn(name = "host_id")
	    private Host host;
	    @JsonIgnore
	    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	    private List<Booking> bookings;
}
