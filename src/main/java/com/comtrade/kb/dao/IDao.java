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
public interface IDao<E> {

	List<E> findAll();

	E findById(Long id);


	E save(E articles);

	void delete(E articles);
}//end IDao
