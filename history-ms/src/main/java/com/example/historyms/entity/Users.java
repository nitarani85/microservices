package com.example.historyms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String name;
	private String email;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
	private List<Post> posts =new ArrayList<Post>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(Long userId, String userName, String name, String email, List<Post> posts) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.email = email;
		this.posts = posts;
	}
	
	
	
}
