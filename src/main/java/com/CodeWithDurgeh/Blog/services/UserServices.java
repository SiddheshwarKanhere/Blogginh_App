package com.CodeWithDurgeh.Blog.services;

import java.util.List;

import com.CodeWithDurgeh.Blog.paylodes.UserDto;

public interface UserServices {

	UserDto registerNewUser(UserDto user);
	
	UserDto createUser (UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
	







}
