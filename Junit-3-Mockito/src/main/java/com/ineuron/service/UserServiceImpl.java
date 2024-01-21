package com.ineuron.service;

import com.ineuron.repo.UserRepository;

public class UserServiceImpl implements IUserService {
	
	private UserRepository repository;
	
	
	

	public UserServiceImpl() {
	}

	public UserServiceImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public boolean registerUser(String username, String role, String pass) {

		if (username.isBlank() || role.equalsIgnoreCase("visitor") || pass.isBlank()) 
			return false;
		
		int count = repository.addUser(username, role, pass);
		
		return count!=0?true:false;
		
	}

	@Override
	public boolean authUser(String username, String pass) {
		
		if (username.isBlank() || pass.isBlank()) 
			throw new IllegalArgumentException("please provide valid data");
		
		boolean response = repository.authenticateUser(username, pass);
		
		return response;
	}

}
