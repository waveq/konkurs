/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waveq.konkurs.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Szymon
 */
@Entity
@Table(name = "countrylanguage")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Countrylanguage.findAll", query = "SELECT c FROM Countrylanguage c"),
		@NamedQuery(name = "Countrylanguage.findByCountrycode", query = "SELECT c FROM Countrylanguage c WHERE c.countrylanguagePK.countrycode = :countrycode"),
		@NamedQuery(name = "Countrylanguage.findByLanguage", query = "SELECT c FROM Countrylanguage c WHERE c.countrylanguagePK.language = :language"),
		@NamedQuery(name = "Countrylanguage.findByIsofficial", query = "SELECT c FROM Countrylanguage c WHERE c.isofficial = :isofficial"),
		@NamedQuery(name = "Countrylanguage.findByPercentage", query = "SELECT c FROM Countrylanguage c WHERE c.percentage = :percentage"),
		@NamedQuery(name = "Countrylanguage.findAllSorted", query = "SELECT c FROM Countrylanguage c "
				+ "ORDER BY c.country.population DESC, c.countrylanguagePK.language ASC"),
		@NamedQuery(name = "Countrylanguage.findLanguageAndPopulation", query = "SELECT c.countrylanguagePK.language AS lang, "
				+ "SUM(c.country.population * c.percentage)  * 0.01 AS population, "
				+ "population "
				+ "FROM Countrylanguage c "
				+ "GROUP BY lang "
				+ "ORDER BY population DESC, lang ASC"),
		@NamedQuery(name = "Country.getWholePopulation", query = "SELECT SUM(c.country.population * c.percentage) FROM Countrylanguage c"),
		@NamedQuery(name = "Countrylanguage.findByIsofficialSorted", query = "SELECT c.country.continent, "
				+ "c.country.name, "
				+ "c.countrylanguagePK.language, "
				+ "c.country.population, "
				+ "c.percentage, "
				+ "c.country.population, "
				+ "c.country.code "
				+ "FROM Countrylanguage c "
				+ "WHERE c.isofficial = :isofficial "
				+ "ORDER BY c.country.continent ASC, c.country.name ASC, c.percentage DESC") })
public class Countrylanguage implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected CountrylanguagePK countrylanguagePK;
	@Basic(optional = false)
	@NotNull
	@Column(name = "isofficial", nullable = false)
	private boolean isofficial;
	@Basic(optional = false)
	@NotNull
	@Column(name = "percentage", nullable = false)
	private float percentage;
	@JoinColumn(name = "countrycode", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Country country;

	public Countrylanguage() {
	}

	public Countrylanguage(CountrylanguagePK countrylanguagePK) {
		this.countrylanguagePK = countrylanguagePK;
	}

	public Countrylanguage(CountrylanguagePK countrylanguagePK,
			boolean isofficial, float percentage) {
		this.countrylanguagePK = countrylanguagePK;
		this.isofficial = isofficial;
		this.percentage = percentage;
	}

	public Countrylanguage(String countrycode, String language) {
		this.countrylanguagePK = new CountrylanguagePK(countrycode, language);
	}

	public CountrylanguagePK getCountrylanguagePK() {
		return countrylanguagePK;
	}

	public void setCountrylanguagePK(CountrylanguagePK countrylanguagePK) {
		this.countrylanguagePK = countrylanguagePK;
	}

	public boolean getIsofficial() {
		return isofficial;
	}

	public void setIsofficial(boolean isofficial) {
		this.isofficial = isofficial;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (countrylanguagePK != null ? countrylanguagePK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Countrylanguage)) {
			return false;
		}
		Countrylanguage other = (Countrylanguage) object;
		if ((this.countrylanguagePK == null && other.countrylanguagePK != null)
				|| (this.countrylanguagePK != null && !this.countrylanguagePK
						.equals(other.countrylanguagePK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.waveq.konkurs.entity.Countrylanguage[ countrylanguagePK="
				+ countrylanguagePK + " ]";
	}

}
