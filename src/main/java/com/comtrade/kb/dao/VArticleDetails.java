/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.kb.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author radoo
 */
@Entity
@Table(name = "V_ARTICLE_DETAILS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "VArticleDetails.findAll", query = "SELECT v FROM VArticleDetails v")
	, @NamedQuery(name = "VArticleDetails.findByArticleId", query = "SELECT v FROM VArticleDetails v WHERE v.articleId = :articleId")
	, @NamedQuery(name = "VArticleDetails.findByDescription", query = "SELECT v FROM VArticleDetails v WHERE upper(v.description) LIKE upper(:description)")
	, @NamedQuery(name = "VArticleDetails.findByDetailDescription", query = "SELECT v FROM VArticleDetails v WHERE upper(v.detailDescription) LIKE upper(:detailDescription)")})
public class VArticleDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Column(name = "ARTICLE_DETAIL_ID")
	private Integer articleDetailId;
	@Column(name = "ARTICLE_ID")
	private Integer articleId;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "DETAIL_DESCRIPTION")
	private String detailDescription;

	public VArticleDetails() {
	}

	public Integer getArticleDetailId() {
		return articleDetailId;
	}

	public void setArticleDetailId(Integer articleDetailId) {
		this.articleDetailId = articleDetailId;
	}
	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	@Override
	public String toString() {
		return "VArticleDetails{" + "articleDetailId=" + articleDetailId + ", articleId=" + articleId + ", description=" + description + ", detailDescription=" + detailDescription + '}';
	}

	

}//end VArticleDetails
