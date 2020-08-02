package com.app.response;

import java.util.List;

import com.app.entity.Article;



public class Response {
	
	private String statusCode;
	
	private List<Article> list;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public List<Article> getList() {
		return list;
	}

	public void setList(List<Article> list) {
		this.list = list;
	}
	
	
	

}
