package com.CodeWithDurgeh.Blog.services;

import com.CodeWithDurgeh.Blog.paylodes.CommentDto;

public interface CommentService {

	
	CommentDto createComment(CommentDto commentId,Integer postId);

	void DeleteComment(Integer commentId);
}
