package com.homesteadhorizen.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homesteadhorizen.entity.Host;
import com.homesteadhorizen.entity.Property;
import com.homesteadhorizen.repository.PropertyRepo;
import com.homesteadhorizen.service.PropertyService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	private PropertyRepo pr;

	@Override
	public Property addProperty(Property property) {
		property.setBookings(new ArrayList<>());
		property.setImg(new HashSet<>());
		log.debug("inside service class of property");
		return pr.save(property);
	}

	@Override
	public List<Property> findAll() {

		return pr.findAll();
	}

	@Override
	public Property updateProp(Property prop) {
        Optional<Property> props= pr.findById(prop.getId());
        if(!props.isPresent()) {
        	throw new NullPointerException("Property is not available with given Id");
        }
        props.get().setRentpernight(prop.getRentpernight());
        Set<String> imgs=props.get().getImg();
        for(String imgurl:prop.getImg()) {
        	imgs.add(imgurl);
        }
        props.get().setImg(imgs);
		return pr.save(props.get());
	}

	@Override
	public List<Property> findByHost(Host host) {
		Optional<List<Property>> list=pr.findByHost(host);
		if(!list.isPresent()) {
			throw new NullPointerException("provided host is not catain any property");
		}
		return list.get();
	}

	@Override
	public Property delete(long id) {
		Optional<Property> prop= pr.findById(id);
		if(prop.isPresent()) {
			pr.delete(prop.get());
		}
		return prop.get();
	}

	

}
