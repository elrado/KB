package com.comtrade.kb.dao;

import com.comtrade.kb.dao.ArticleDetails;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-19T19:54:10")
@StaticMetamodel(Articles.class)
public class Articles_ { 

    public static volatile CollectionAttribute<Articles, ArticleDetails> articleDetailsCollection;
    public static volatile SingularAttribute<Articles, Integer> articleId;
    public static volatile SingularAttribute<Articles, String> description;

}