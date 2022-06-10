package com.lt.src.serviceInt;

import com.lt.src.bean.User;

public interface UserServiceInterface {

	public User userLogin();
	public User userLogout(User user);
	public void registerUser();
	public void resetPassword();
	public void updatePassword();
}
