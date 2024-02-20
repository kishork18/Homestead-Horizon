package com.homesteadhorizen.service;

import java.util.List;
import java.util.Set;

import com.homesteadhorizen.entity.Host;
import com.homesteadhorizen.entity.Property;

public interface PropertyService {
 public Property addProperty(Property property);
 public List<Property> findAll();
 public Property updateProp(Property prop);
 public List<Property> findByHost(Host host);
 public Property delete(long id);
 
}
