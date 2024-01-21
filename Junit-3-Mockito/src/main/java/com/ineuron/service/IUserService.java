package com.ineuron.service;

public interface IUserService {
	
	public boolean registerUser(String username,String role,String pass);
	
	public boolean authUser(String username,String pass);

}
