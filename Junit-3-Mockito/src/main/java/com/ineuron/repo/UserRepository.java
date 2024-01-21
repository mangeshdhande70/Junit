package com.ineuron.repo;

public interface UserRepository {

	public int addUser(String username, String role, String pass);

	public boolean authenticateUser(String username, String pass);

}
