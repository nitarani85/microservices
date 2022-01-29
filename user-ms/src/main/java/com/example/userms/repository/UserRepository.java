package com.example.userms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userms.enitity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByUserId(Long userId);
	public Users findByUserName(String userName);
}
