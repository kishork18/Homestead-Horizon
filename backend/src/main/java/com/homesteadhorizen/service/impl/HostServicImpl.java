package com.homesteadhorizen.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homesteadhorizen.entity.Host;
import com.homesteadhorizen.entity.HostStatus;
import com.homesteadhorizen.repository.HostRepo;
import com.homesteadhorizen.service.HostService;

@Service
public class HostServicImpl implements HostService {
	
	@Autowired
	private HostRepo hostrepo;

	@Override
	public Host createHost(Host host) {
		
		host.setHostingSince(LocalDate.now());
		host.setHostStatus(HostStatus.ACTIVE);
		host.setProperties(new ArrayList<>());
		host.setTotalEarnings(0);
		return hostrepo.save(host);
	}

	@Override
	public List<Host> viewHostList() {
		List<Host> list=hostrepo.findAll();
		if(list.isEmpty()) {
			throw new NullPointerException("No host register still now");
		}
		
		return list;
	}

	@Override
	public Host getHostByEmail(String email) {
		Host h=hostrepo.findByEmail(email).get();
		if(h==null) {
			throw new RuntimeException("Account Not exists with "+ email);
		}
		return h;
	}

	@Override
	public Host updateHost(Host host) {
		
		Host h=hostrepo.findByEmail(host.getEmail()).get();
		if(h==null) {
			throw new RuntimeException("Account Not exists with "+ host.getEmail());
		}
		h.setAbout(host.getAbout());
		h.setHostStatus(host.getHostStatus());
		h.setName(host.getName());
		h.setTotalEarnings(host.getTotalEarnings());
		return hostrepo.save(h);
		
	}

	@Override
	public Host deleteHost(String email) {
		Host host= hostrepo.findByEmail(email).get();
		if(host==null) {
			throw new RuntimeException("Account Not exists with "+ host.getEmail());
		}
		hostrepo.delete(host);
		return host;
	}

}
