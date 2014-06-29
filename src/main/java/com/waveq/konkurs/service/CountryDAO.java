package com.waveq.konkurs.service;

import com.waveq.konkurs.entity.Country;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Szymon
 */
@Stateless
public class CountryDAO {

	@PersistenceContext
	EntityManager em;

	public Country find(String code) {
		return em.find(Country.class, code);
	}
}
