/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.kb.dao;

import java.util.List;

/**
 *
 * @author radoo
 */
public interface IArticleDetailsDAO extends IDao<ArticleDetails>{
	Articles findByDescription(String description);
	List<Articles> findByDetailsDescription(String description);
}//end ArticlesService
