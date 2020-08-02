package com.app.service;

import java.util.List;

import com.app.entity.Article;

public interface ArticleService {

	public String createArticle(Article article);
	public List<Article> getAllArticles();
}
