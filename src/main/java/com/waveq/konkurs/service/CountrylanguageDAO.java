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
public class CountrylanguageDAO {

	@PersistenceContext
	private EntityManager em;

	public List findAllCountrylanguages() {
		return em.createNamedQuery(
				"Countrylanguage.findLanguageAndPopulation").getResultList();
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
