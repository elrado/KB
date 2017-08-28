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
@Service("VArticleDetailsService")
@Repository
@Transactional
public class VArticleDetailsDAO implements IVArticleDetailsDAO {

	@PersistenceContext(unitName = "kb")
	EntityManager em;

	@Override
	public List<VArticleDetails> findByDescription(String description) {
		TypedQuery<VArticleDetails> query = em.createNamedQuery("VArticleDetails.findByDescription", VArticleDetails.class);
		query.setParameter("description", "%" + description + "%");
		return query.getResultList();
	}
	@Override
	public List<VArticleDetails> findByDetailDescription(String description) {
		TypedQuery<VArticleDetails> query = em.createNamedQuery("VArticleDetails.findByDetailDescription", VArticleDetails.class);
		query.setParameter("detailDescription", "%" + description + "%");
		return query.getResultList();
	}

	@Override
	public List<VArticleDetails> findAll() {
		List<VArticleDetails> articles = em.createNamedQuery("VArticleDetails.findAll", VArticleDetails.class).getResultList();
		return articles;
	}

	@Override
	public VArticleDetails findById(Long id) {
		TypedQuery<VArticleDetails> query = em.createNamedQuery("VArticleDetails.findByArticleId", VArticleDetails.class);
		query.setParameter("articleId", id.intValue());
		return query.getSingleResult();
	}

	@Override
	public VArticleDetails save(VArticleDetails articles) {
		throw new UnsupportedOperationException("Not updatable view"); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void delete(VArticleDetails articles) {
		throw new UnsupportedOperationException("Not updatable view"); //To change body of generated methods, choose Tools | Templates.
	}


}//end VArticleDetailsDAO
