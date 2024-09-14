package com.CodeWithDurgeh.Blog.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CodeWithDurgeh.Blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
