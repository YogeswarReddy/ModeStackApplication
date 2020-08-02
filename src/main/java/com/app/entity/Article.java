package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ARTICLE")

public class Article {

	@Id
	@Column(name = "ARTICLE_ID")
	@SequenceGenerator(name = "ARTICLE_ID",initialValue = 1001,allocationSize = 1,sequenceName = "ARTICLE_ID_SEQ")
	@GeneratedValue(generator = "ARTICLE_ID")
	@JsonIgnore
	private Integer articleId;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "BODY",length = 2000)
	private String body;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	@JsonIgnore
    private User user;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article(Integer articleId, String title, String body, String author, User user) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.body = body;
		this.author = author;
		this.user = user;
	}
	
	
	public Article() {
		// TODO Auto-generated constructor stub
	}
	
}
