package com.example.userms.enitity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="post")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long postId;
	private String url;
	
	@ManyToOne
	@JsonBackReference
	private Users user;

	@Convert(converter = StringSetConverter.class)
	private Set<String> userLikes=new HashSet<String>();
	
	@Convert(converter = StringSetConverter.class)
	private Set<String> userDislikes=new HashSet<String>();
	
	@Convert(converter = StringSetConverter.class)
	private Set<String> Views=new HashSet<String>();

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Set<String> getUserLikes() {
		return userLikes;
	}

	public void setUserLikes(Set<String> userLikes) {
		this.userLikes = userLikes;
	}

	public Set<String> getUserDislikes() {
		return userDislikes;
	}

	public void setUserDislikes(Set<String> userDislikes) {
		this.userDislikes = userDislikes;
	}

	public Set<String> getViews() {
		return Views;
	}

	public void setViews(Set<String> views) {
		Views = views;
	}

	public Post(Long postId, String url, Users user, Set<String> userLikes, Set<String> userDislikes,
			Set<String> views) {
		super();
		this.postId = postId;
		this.url = url;
		this.user = user;
		this.userLikes = userLikes;
		this.userDislikes = userDislikes;
		Views = views;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
