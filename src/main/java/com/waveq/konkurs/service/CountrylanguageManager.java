/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waveq.konkurs.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Szymon
 */
@Stateless
public class CountrylanguageManager {

	@PersistenceContext
	EntityManager em;

	public List findAllCountrylanguages() {
		List l = em.createNamedQuery(
				"Countrylanguage.findLanguageAndPopulation").getResultList();
		return l;
	}

	public List findOfficialCountrylanguages() {
		return em.createNamedQuery("Countrylanguage.findByIsofficial")
				.setParameter("isofficial", true).getResultList();
	}

	public List findSortedOfficialCountrylanguages() {
		return em.createNamedQuery("Countrylanguage.findByIsofficialSorted")
				.setParameter("isofficial", true).getResultList();
	}

	public List findCountryLanguagesByCode(String code) {
		return em.createNamedQuery("Countrylanguage.findByCountrycode")
				.setParameter("countrycode", code).getResultList();
	}

	public List getWholePopulation() {
		return em.createNamedQuery("Country.getWholePopulation")
				.getResultList();
	}

}
