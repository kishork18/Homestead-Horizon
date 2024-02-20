package com.homesteadhorizen.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.homesteadhorizen.entity.CurrentHostSession;
import com.homesteadhorizen.entity.Guest;
import com.homesteadhorizen.entity.Host;
import com.homesteadhorizen.entity.LoginDTO;
import com.homesteadhorizen.repository.GuestRepo;
import com.homesteadhorizen.repository.HostRepo;
import com.homesteadhorizen.repository.SessionRepo;
import com.homesteadhorizen.service.LoginService;
import net.bytebuddy.utility.RandomString;
@Service
public class LoginServiceImpl implements LoginService {
	private HostRepo hr;
	private GuestRepo gr;
	private SessionRepo sr;

	public LoginServiceImpl(HostRepo hr, GuestRepo gr, SessionRepo sr) {
		super();
		this.hr = hr;
		this.gr = gr;
		this.sr = sr;
	}

	@Override
	public CurrentHostSession login(LoginDTO login) {
		Host host=null;
		Guest guest=null;
		if(hr.findByEmail(login.getEmail()).isPresent()) {
			host=hr.findByEmail(login.getEmail()).get();
		}else if(gr.findByEmail(login.getEmail()).isPresent()) {
			guest=gr.findByEmail(login.getEmail()).get();
		}
		else {
			throw new NullPointerException("Email is not valid please provid valid email");
		}
		Optional<CurrentHostSession> currsession=null;
		if(host!=null) {
			currsession=sr.findById(host.getEmail());
		}else {
			currsession=sr.findById(guest.getEmail());
		}
		if(currsession.isPresent()) {
			throw new RuntimeException("User is already Loged in into system ");
		}
		if(host!=null) {
			if(host.getPassword().equals(login.getPassword())) {
				String key=RandomString.make(6);
				CurrentHostSession chs= new CurrentHostSession(host.getEmail(), "host", key, LocalDateTime.now());
				sr.save(chs);
				return chs;
			}else {
				throw new RuntimeException("Password is incorrect please enter currect password");
			}
		}
		else {
			if(guest.getPassword().equals(login.getPassword())) {
				String key=RandomString.make(6);
				CurrentHostSession chs= new CurrentHostSession(guest.getEmail(), "guest", key, LocalDateTime.now());
				sr.save(chs);
				return chs;
			}else {
				throw new RuntimeException("Password is incorrect please enter currect password");
			}
		}
	
	}

	@Override
	public String logOutFromAccount(String key) {
		CurrentHostSession chs= sr.findByUuid(key);
		if(chs==null) {
			throw new NullPointerException("User is not logged in");
		}
		sr.delete(chs);
		return "Logout successfully";
	}

}
