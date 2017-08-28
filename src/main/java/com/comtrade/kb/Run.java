/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.kb;

import com.comtrade.kb.dao.Articles;
import com.comtrade.kb.dao.ArticlesDAO;
import com.comtrade.kb.dao.IArticleDetailsDAO;
import com.comtrade.kb.dao.IArticlesDAO;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.comtrade.kb.dao.IVArticleDetailsDAO;
import com.comtrade.kb.dao.VArticleDetails;

public class Run {

	private static final Logger logger = Logger.getLogger(Run.class);

	public static void main(String[] args) {
		ApplicationContext ctx
			= new AnnotationConfigApplicationContext(Config.class);
		IArticlesDAO articlesDAO = (IArticlesDAO) ctx.getBean("ArticlesService", IArticlesDAO.class);
		IVArticleDetailsDAO iVArticleDetailsDAO = (IVArticleDetailsDAO) ctx.getBean("VArticleDetailsService", IVArticleDetailsDAO.class);

		/*List<Articles> articles = articlesDAO.findAll();
		
		for (Articles art : articles) {
			System.out.println(art);
		}
		articles = articlesDAO.findByDescription("vand");
		
		for (Articles art : articles) {
			System.out.println(art);
		}
		articles = articlesDAO.findByDetailsDescription("");
		
		for (Articles art : articles) {
			System.out.println(art);
		}
		*/
		List<VArticleDetails> adetails;
		adetails = iVArticleDetailsDAO.findByDescription("VAn");
		
		for (VArticleDetails art : adetails) {
			System.out.println(art);
		}

		adetails = iVArticleDetailsDAO.findByDetailDescription("enum");
		
		for (VArticleDetails art : adetails) {
			System.out.println(art);
		}

		VArticleDetails article = iVArticleDetailsDAO.findById(1L);
		System.out.println(article);
	}
}//end Run
