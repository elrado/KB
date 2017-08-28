/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.kb.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radoo
 */
@Service("ArticlesService")
@Repository
@Transactional
public class ArticlesDAO implements IArticlesDAO{

	@PersistenceContext(unitName = "kb")
	EntityManager em;

	@Override
	public List<Articles> findByDescription(String description) {
		TypedQuery<Articles> query = em.createNamedQuery("Articles.findByDescription", Articles.class);
		query.setParameter("description",  "%" + description + "%");
		return query.getResultList();
	}

	@Override
	public List<Articles> findAll() {
		List<Articles> articles = em.createNamedQuery("Articles.findAll", Articles.class).getResultList();
		return articles;
	}

	@Override
	public Articles findById(Long id) {
		TypedQuery<Articles> query = em.createNamedQuery("Articles.findById", Articles.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public List<Articles> findByDetailsDescription(String description){
		TypedQuery<Articles> query = em.createNamedQuery("Articles.findByDetailsDescription", Articles.class);
		query.setParameter("description", "%" + description + "%");
		return query.getResultList();
	}

	@Override
	public Articles save(Articles articles) {
		if (articles.getArticleId()== null) {
			em.persist(articles);
		} else {
			em.merge(articles);
		}
		return articles;		
	}

	@Override
	public void delete(Articles articles) {
		em.remove(em.contains(articles) ? articles : em.merge(articles));
	}

}//end ArticlesDAO
