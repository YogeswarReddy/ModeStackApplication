package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.ArticleConstants;
import com.app.common.UserConstants;
import com.app.entity.Article;
import com.app.service.impl.ArticleServiceImpl;


@RestController
public class AtricleController {

	@Autowired
	private ArticleServiceImpl articleServiceImpl;
	
	

	@PostMapping("/articles")
	public ResponseEntity<Map<String, Map<String, Object>>> createArticle(@RequestBody Article article) {

		String msg = articleServiceImpl.createArticle(article);
		Map<String, String> responseMessage = new HashMap<>();
		Map<String, Object> responseStatusCode = new HashMap<>();
		Map<String, Map<String, Object>> response = new HashMap<>();
		
		
		responseMessage.put("Message", msg);
		responseStatusCode.put(UserConstants.STATUS_CODE, ArticleConstants.USER_ARTICLE_STATUS_CODE_MSG);
		responseStatusCode.put(UserConstants.BODY, responseMessage);
		response.put(UserConstants.RESPONSE, responseStatusCode);

		return new ResponseEntity<Map<String, Map<String, Object>>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/articles")
	public ResponseEntity<Object> getAllArticles() {

		Map<String, Object> responseStatusCode = new HashMap<>();
				
		List<Article> allArticles = articleServiceImpl.getAllArticles();
		
        
		responseStatusCode.put(UserConstants.STATUS_CODE, ArticleConstants.USER_GET_ARTICLE_STATUS_CODE_MSG);
		Map<String,List<Article>> dataMap=new HashMap<>();
		dataMap.put("data",allArticles);
		Map<Object, Object> respMap= new HashMap<>();
		
		responseStatusCode.put(UserConstants.BODY,dataMap);
		//response.put(, responseStatusCode);
				
		respMap.put(UserConstants.RESPONSE, responseStatusCode);
	
		return new ResponseEntity<Object>(respMap, HttpStatus.OK);

	}

	

}
