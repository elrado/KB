/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.kb.dao;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author radoo
 */
@Entity
@Table(name = "ARTICLES")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Articles.findAll", query = "SELECT a FROM Articles a")
	, @NamedQuery(name = "Articles.findByArticleId", query = "SELECT a FROM Articles a WHERE a.articleId = :articleId")
	, @NamedQuery(name = "Articles.findByDescription", query = "SELECT a FROM Articles a WHERE UPPER( a.description) LIKE UPPER( :description)")
	, @NamedQuery(name = "Articles.findByDetailsDescription", query = "SELECT a FROM Articles a INNER JOIN FETCH  a.articleDetailsCollection ad WHERE UPPER( ad.description) LIKE UPPER( :description)")})
public class Articles implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer articleId;
	private String description;
	private Collection<ArticleDetails> articleDetailsCollection;

	public Articles() {
	}

	public Articles(Integer articleId) {
		this.articleId = articleId;
	}

	@Id
	@Column(name = "ARTICLE_ID")
	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	@OneToMany(mappedBy = "articleId", cascade = CascadeType.ALL, orphanRemoval = true)
	public Collection<ArticleDetails> getArticleDetailsCollection() {
		return articleDetailsCollection;
	}

	public void setArticleDetailsCollection(Collection<ArticleDetails> articleDetailsCollection) {
		this.articleDetailsCollection = articleDetailsCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (articleId != null ? articleId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Articles)) {
			return false;
		}
		Articles other = (Articles) object;
		if ((this.articleId == null && other.articleId != null) || (this.articleId != null && !this.articleId.equals(other.articleId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Articles{" + "articleId=" + articleId + ", description=" + description + '}';
	}

}//end Articles
