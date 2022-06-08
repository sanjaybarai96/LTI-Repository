package com.crs.lt.service;

import com.crs.lt.beans.User;

public interface UserServiceInterface {
	public User userLogin();
	public User userLogout(User user);
	public void registerUser();
	public void resetPassword();
	public void updatePassword();
}
