package com.homesteadhorizen.service;

import java.util.List;

import com.homesteadhorizen.entity.Host;

public interface HostService {
  public Host createHost(Host host);
  public List<Host> viewHostList();
  public Host getHostByEmail(String email);
  public Host updateHost (Host host);
  public Host deleteHost(String email);
}
