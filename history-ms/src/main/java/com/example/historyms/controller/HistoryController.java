package com.example.historyms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.historyms.entity.History;
import com.example.historyms.repository.HistoryRepo;

@RestController
@RequestMapping("/history")
public class HistoryController {
	
	@Autowired
	public HistoryRepo historyrepo;

	@PostMapping("/addHistory/{postId}/{userId}")
	public History postHistory(@PathVariable Long userId,@PathVariable Long postId,@RequestBody History history) {
		history.setUserId(userId);
		history.setPostId(postId);
		return historyrepo.save(history);
	}
	
	@GetMapping("/getHistory/{userId}")
	public List<History> history(@PathVariable Long userId){
		return historyrepo.findByUserId(userId);
	}
}
