package com.example.userms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.userms.enitity.Users;
import com.example.userms.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userrepo;

	@GetMapping("/index")
	public String status(Model m)
	{
		return "index";
	}
	
	@PostMapping("/login")
	public String userDetails(@ModelAttribute("users") Users u)
	{
		System.out.println(u.getName());
		 userrepo.save(u);
		 return "Login";
	}
	@GetMapping("/login/{userName}")
	public String userLogin(@PathVariable String userName)
	{
		userrepo.findByUserName(userName);
		return userName;
	}
	@GetMapping("/allUser")
	public List<Users> getAllUsers()
	{
		return userrepo.findAll();
	}
	
	@GetMapping("/getuser/{userId}")
	public Users getUser(@PathVariable Long userId)
	{
		return userrepo.findByUserId(userId);
	}

}









