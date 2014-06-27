/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waveq.konkurs.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Szymon
 */
@Entity
@Table(name = "city")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
		@NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id"),
		@NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name"),
		@NamedQuery(name = "City.findByCountrycode", query = "SELECT c FROM City c WHERE c.countrycode = :countrycode"),
		@NamedQuery(name = "City.findByDistrict", query = "SELECT c FROM City c WHERE c.district = :district"),
		@NamedQuery(name = "City.findByPopulation", query = "SELECT c FROM City c WHERE c.population = :population") })
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id", nullable = false)
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "name", nullable = false, length = 2147483647)
	private String name;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 3)
	@Column(name = "countrycode", nullable = false, length = 3)
	private String countrycode;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "district", nullable = false, length = 2147483647)
	private String district;
	@Basic(optional = false)
	@NotNull
	@Column(name = "population", nullable = false)
	private int population;
	@OneToMany(mappedBy = "capital", fetch = FetchType.LAZY)
	private List<Country> countryList;

	public City() {
	}

	public City(Integer id) {
		this.id = id;
	}

	public City(Integer id, String name, String countrycode, String district,
			int population) {
		this.id = id;
		this.name = name;
		this.countrycode = countrycode;
		this.district = district;
		this.population = population;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@XmlTransient
	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof City)) {
			return false;
		}
		City other = (City) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.waveq.konkurs.entity.City[ id=" + id + " ]";
	}

}
