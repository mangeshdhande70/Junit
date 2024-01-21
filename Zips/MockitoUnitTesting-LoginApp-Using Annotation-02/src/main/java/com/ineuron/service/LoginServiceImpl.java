package com.ineuron.service;

import com.ineuron.dao.ILoginDao;


public class LoginServiceImpl implements ILoginService {
	
	
	public ILoginDao dao;
	
	
	
	public LoginServiceImpl() {
	}



	public LoginServiceImpl(ILoginDao dao) {
		super();
		this.dao = dao;
	}



	@Override
	public boolean login(String username, String password) {
		
		if (username.equals("") || password.equals("")) {
			throw new IllegalArgumentException("Username or Password is Empty");
		}
		
		int count = dao.authenticate(username, password);
		
		if (count==0) 
			return false;
		
		return true;
	}



	@Override
	public String registerUser(String username, String role) {
		
		if (!username.equalsIgnoreCase("") && !role.equalsIgnoreCase("visitor")) {
			dao.addUser(username, role);
			return "User Added";
		}
		
		return "User Not Added";
	}

}
