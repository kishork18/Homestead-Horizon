package com.homesteadhorizen.service;

import com.homesteadhorizen.entity.CurrentHostSession;
import com.homesteadhorizen.entity.LoginDTO;

public interface LoginService {
 public CurrentHostSession login(LoginDTO login);
 public String logOutFromAccount(String key) ;
}
