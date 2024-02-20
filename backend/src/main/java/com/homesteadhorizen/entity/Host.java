package com.homesteadhorizen.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class Host  {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    @Column(unique = true, nullable=false)
	    private String email;
	    @JsonProperty(access =  Access.WRITE_ONLY)
	    private String password;
	    private double totalEarnings;
	    private String about;
	    @Enumerated(EnumType.STRING)
	    private HostStatus hostStatus;
	    
	    @JsonIgnore
	    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
	    private List<Property> properties;
	    private LocalDate hostingSince;
		
}
