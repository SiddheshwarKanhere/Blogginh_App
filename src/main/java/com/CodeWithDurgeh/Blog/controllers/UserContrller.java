package com.CodeWithDurgeh.Blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CodeWithDurgeh.Blog.paylodes.ApiResponce;
import com.CodeWithDurgeh.Blog.paylodes.UserDto;
import com.CodeWithDurgeh.Blog.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserContrller {

	@Autowired
	private UserServices userServices;

	// post-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

		UserDto createUserDto = this.userServices.createUser(userDto);

		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	// put -update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid) {

		UserDto updateUser = this.userServices.updateUser(userDto, uid);

		return ResponseEntity.ok(updateUser);

	}
     // admin
	//DELETE-delete user
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponce> deleteUser(@PathVariable("userId") Integer uid) {

		this.userServices.deleteUser(uid);
		return new ResponseEntity<ApiResponce>(new ApiResponce("User deleted Successfully", true), HttpStatus.OK);

	}
	
	//GET -user get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		return ResponseEntity.ok(this.userServices.getAllUsers());
		}

	//GET -user get
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
			
			return ResponseEntity.ok(this.userServices.getUserById(userId));
			}
       @PostMapping("/")
       public ResponseEntity<List> getAllData(){
       }

}
