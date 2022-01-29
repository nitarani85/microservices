package com.example.uploadms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.uploadms.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	public Post findByPostId(Long postId);
}
