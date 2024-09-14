package com.CodeWithDurgeh.Blog.paylodes;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String username;
	
	private String password;
}
