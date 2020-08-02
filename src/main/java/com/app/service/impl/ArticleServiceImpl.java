package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.ArticleConstants;
import com.app.entity.Article;
import com.app.entity.User;
import com.app.repository.ArticleRepository;
import com.app.repository.UserRepository;
import com.app.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	private ArticleRepository articleRepo;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String createArticle(Article article) {
		User user=new User();
		if(userRepository.existsByUsername(article.getAuthor())){
			 user = userRepository.findByUsername(article.getAuthor());
		}
		article.setUser(user);
		Article registeredArticle = articleRepo.save(article);
			
		return registeredArticle.getArticleId()!=null?ArticleConstants.ARTICLE_CREATED:ArticleConstants.ARTICLE_NOT_CREATED;
	}

	@Override
	public List<Article> getAllArticles() {
		
//		Pageable sortedByName = 
//				  PageRequest.of(0, 0, Sort.by(""));
//		Page<Article> pageableAllArticles = articleRepo.findAll(sortedByName);
		
		List<Article> allArticles = articleRepo.findAll();
		
		return allArticles;
	}

}
