package com.example.userms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.userms.enitity.Users;
import com.example.userms.repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	RestTemplate resttemplate;
	
	@Autowired
	UserRepository userrepo;

	@GetMapping("/index")
	public String status(Model m)
	{
		return "index";
	}
	
	@PostMapping("/register")
	public Users userDetails(@RequestBody Users u)
	{
		 userrepo.save(u);
		 return u;
	}
	@GetMapping("/connect-to-chat")
	public void userLogin(@ModelAttribute("users") Users u)
	{
		String s= this.resttemplate.getForObject("http://localhost:8020/chat", String.class);
		System.out.println(s);
		/*
		 * return resttemplate.headForHeaders("http://localhost:8020/chat");
		 */	
	}
	@GetMapping("/allUser/{userName}")
	public List<Users> getAllUsers(@PathVariable String userName)
	{
		return userrepo.filter(userName);
	}
	
	@GetMapping("/login/{userName}")
	public Users getUser(@PathVariable String userName)
	{
		return userrepo.findByUserName(userName);
	}
	
}







