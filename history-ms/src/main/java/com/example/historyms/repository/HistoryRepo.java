package com.example.historyms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.historyms.entity.History;

public interface HistoryRepo extends JpaRepository<History,Long> {

	public List<History> findByUserId(Long userId);
}
