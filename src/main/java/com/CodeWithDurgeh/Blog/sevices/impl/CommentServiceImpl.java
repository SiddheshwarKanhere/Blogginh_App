package com.CodeWithDurgeh.Blog.sevices.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodeWithDurgeh.Blog.entities.Comment;
import com.CodeWithDurgeh.Blog.entities.Post;
import com.CodeWithDurgeh.Blog.exceptions.ResourceNotFoundException;
import com.CodeWithDurgeh.Blog.paylodes.CommentDto;
import com.CodeWithDurgeh.Blog.repositorys.CommentRepo;
import com.CodeWithDurgeh.Blog.repositorys.PostRepo;
import com.CodeWithDurgeh.Blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		
		Comment savedComment = this.commentRepo.save(comment);
		
		return this.modelMapper.map(savedComment,CommentDto.class);
	}

	@Override
	public void DeleteComment(Integer commentId) {
		Comment com=this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "Comment Id", commentId));
		this.commentRepo.delete(com);
		
	}

}
