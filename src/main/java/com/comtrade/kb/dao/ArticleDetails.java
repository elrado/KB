/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.kb.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author radoo
 */
@Entity
@Table(name = "ARTICLE_DETAILS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ArticleDetails.findAll", query = "SELECT a FROM ArticleDetails a")
	, @NamedQuery(name = "ArticleDetails.findByArticleDetailId", query = "SELECT a FROM ArticleDetails a WHERE a.articleDetailId = :articleDetailId")
	, @NamedQuery(name = "ArticleDetails.findByDescription", query = "SELECT a FROM ArticleDetails a WHERE a.description = :description")})
public class ArticleDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Column(name = "ARTICLE_DETAIL_ID")
	private Integer articleDetailId;
	@Column(name = "DESCRIPTION")
	private String description;
	@JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ARTICLE_ID")
        @ManyToOne(fetch = FetchType.LAZY)
	private Articles articleId;

	public ArticleDetails() {
	}

	public ArticleDetails(Integer articleDetailId) {
		this.articleDetailId = articleDetailId;
	}

	public Integer getArticleDetailId() {
		return articleDetailId;
	}

	public void setArticleDetailId(Integer articleDetailId) {
		this.articleDetailId = articleDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Articles getArticleId() {
		return articleId;
	}

	public void setArticleId(Articles articleId) {
		this.articleId = articleId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (articleDetailId != null ? articleDetailId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ArticleDetails)) {
			return false;
		}
		ArticleDetails other = (ArticleDetails) object;
		if ((this.articleDetailId == null && other.articleDetailId != null) || (this.articleDetailId != null && !this.articleDetailId.equals(other.articleDetailId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ArticleDetails{" + "articleDetailId=" + articleDetailId + ", description=" + description + ", articleId=" + articleId + '}';
	}
}//end ArticleDetails
