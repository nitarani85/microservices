package com.example.userms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.userms.enitity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByUserId(Long userId);
	public Users findByUserName(String userName);
	@Query("Select u from Users u where u.userName!=?1")
	List<Users> filter(String userName);
}
