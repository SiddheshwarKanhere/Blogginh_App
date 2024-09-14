package com.CodeWithDurgeh.Blog.sevices.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CodeWithDurgeh.Blog.config.AppConstants;
import com.CodeWithDurgeh.Blog.entities.Role;
import com.CodeWithDurgeh.Blog.entities.User;
import com.CodeWithDurgeh.Blog.exceptions.ResourceNotFoundException;
import com.CodeWithDurgeh.Blog.paylodes.UserDto;
import com.CodeWithDurgeh.Blog.repositorys.RoleRepo;
import com.CodeWithDurgeh.Blog.repositorys.UserRepo;
import com.CodeWithDurgeh.Blog.services.UserServices;
@Service
public class UserSrevicesImlp implements UserServices {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User saveUser =this.userRepo.save(user);
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Usre"," Id ",userId));
		
		user.setName(userDto.getName());
		user.setEmail(user.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(user.getAbout());
		
		User updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateUser);
		
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User"," Id ",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users=this.userRepo.findAll();
		
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
	
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
	
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		 userRepo.delete(user);
	}
	
	public User dtoToUser(UserDto userDto) {
		User user= this.modelMapper.map(userDto, User.class);
		
//		User user=new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		
		return user;
		}

	public UserDto userToDto(User user) {
		
		UserDto userDto= this.modelMapper.map(user, UserDto.class);
		
//		UserDto userDto=new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
//		
		return userDto;
		}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		 User user = this.modelMapper.map(userDto, User.class);
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		
	Role role2 = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		
	user.getRoles().add(role2);
	
	User newUser = this.userRepo.save(user);
		
		return this.modelMapper.map(newUser, UserDto.class);
	}
}
  