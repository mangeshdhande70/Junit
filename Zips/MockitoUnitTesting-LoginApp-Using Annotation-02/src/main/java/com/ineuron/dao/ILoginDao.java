package com.ineuron.dao;

public interface ILoginDao {
	
	public int authenticate(String username,String password);
	public int addUser(String username,String role);

}
