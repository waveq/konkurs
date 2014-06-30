package com.waveq.konkurs.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.waveq.konkurs.entity.Countrylanguage;

/**
 * 
 * @author Szymon
 */
@Stateless
public class CountrylanguageDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Object[]> findAllCountrylanguages() {
		return em.createNamedQuery(
				"Countrylanguage.findLanguageAndPopulation").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> findOfficialCountrylanguages() {
		return em.createNamedQuery("Countrylanguage.findByIsofficial")
				.setParameter("isofficial", true).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> findSortedOfficialCountrylanguages() {
		return em.createNamedQuery("Countrylanguage.findByIsofficialSorted")
				.setParameter("isofficial", true).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Countrylanguage> findCountryLanguagesByCode(String code) {
		return em.createNamedQuery("Countrylanguage.findByCountrycode")
				.setParameter("countrycode", code).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Double> getWholePopulation() {
		return em.createNamedQuery("Country.getWholePopulation")
				.getResultList();
	}

}
