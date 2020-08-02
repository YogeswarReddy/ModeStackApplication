package com.app.exceptions;

public class ArticleNotFoundException extends Exception {
	
	private static final long serialVersionUID = -9079454849611061074L;

	public ArticleNotFoundException(String message) {
		super(message);
		
	}
	
	public ArticleNotFoundException() {
		super();
		
	}
	

}
