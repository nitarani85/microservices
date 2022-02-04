package com.example.chatms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

	@GetMapping("/chat")
	public String chat()
	{
		return "index";
	}
	
	/*
	 * @GetMapping("/chat/{userName}") public String login(@ModelAttribute("users"))
	 */

}
