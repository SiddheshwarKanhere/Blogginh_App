package com.CodeWithDurgeh.Blog.paylodes;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

import com.CodeWithDurgeh.Blog.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id ;
	
	@NotEmpty
	@Size(min = 4,message="Username must be min of 4characters !!")
	private String name;
	
	@Email(message="Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min=3,max=10,message="Password must be min of 3 chars and max of 10 char !!")
	private String password;
	
	@NotEmpty
	private String about;

	private Set<RoleDto> roles = new HashSet<>();
	
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getAbout() {
//		return about;
//	}
//
//	public void setAbout(String about) {
//		this.about = about;
//	}
//
//	@Override
//	public String toString() {
//		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", about="
//				+ about + "]";
//	}
//	
}
