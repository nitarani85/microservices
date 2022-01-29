package com.example.uploadms.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.uploadms.entity.History;
import com.example.uploadms.entity.Post;
import com.example.uploadms.entity.Users;
import com.example.uploadms.repository.PostRepository;

@RestController
@RequestMapping("/upload")
public class UploadController {
	
	@Autowired
	PostRepository postrepo;
	
	@Autowired
	RestTemplate restTemplate;
//	
//	@GetMapping("/post")
//	public String uploaded()
//	{
//		return "Done";
//	}

	@PutMapping("/views/{userId}/{postId}")
	public Post views(@PathVariable Long userId,@PathVariable Long postId)
	{
		Post p=postrepo.findByPostId(postId);
		Set<String>u=p.getViews();
		String id=Long.toString(userId);
		u.add(id);
		p.setViews(u);
		return postrepo.save(p);
	}
	
	@PostMapping("/posts/{userId}")
	public Post upload(@PathVariable Long userId,@RequestBody Post p)
	{
		Users user= this.restTemplate.getForObject("http://localhost:8040/user/getuser/"+userId,Users.class);
		p.setUser(user);
		return postrepo.save(p);
	}
	
	@PutMapping("/likes/{userId}/{postId}")
	public Post getLikes(@PathVariable Long userId,@PathVariable Long postId)
	{
		Post h=postrepo.findByPostId(postId);
		Set<String> s=h.getUserLikes();
		String id=Long.toString(userId);
		s.add(id);
		h.setUserLikes(s);
		return postrepo.save(h);
	}
	
	//@PutMapping("/dislikes")
}
