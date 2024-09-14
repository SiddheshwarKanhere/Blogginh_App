package com.CodeWithDurgeh.Blog.services;

import java.util.List;

import com.CodeWithDurgeh.Blog.paylodes.PostDto;
import com.CodeWithDurgeh.Blog.paylodes.PostResponse;

public interface PostService {

	//create
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete 
	
	void deletePost(Integer postId);

   //get All post
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all post by category
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get All posts by user
	List<PostDto> getPostsByUser(Integer userId);

	//search posts
	List<PostDto> searchPosts(String keyword);




}
