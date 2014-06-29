package com.waveq.konkurs.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Szymon
 */
@Embeddable
public class CountrylanguagePK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 3)
	@Column(name = "countrycode", nullable = false, length = 3)
	private String countrycode;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "language", nullable = false, length = 2147483647)
	private String language;

	public CountrylanguagePK() {
	}

	public CountrylanguagePK(String countrycode, String language) {
		this.countrycode = countrycode;
		this.language = language;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (countrycode != null ? countrycode.hashCode() : 0);
		hash += (language != null ? language.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CountrylanguagePK)) {
			return false;
		}
		CountrylanguagePK other = (CountrylanguagePK) object;
		if ((this.countrycode == null && other.countrycode != null)
				|| (this.countrycode != null && !this.countrycode
						.equals(other.countrycode))) {
			return false;
		}
		if ((this.language == null && other.language != null)
				|| (this.language != null && !this.language
						.equals(other.language))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.waveq.konkurs.entity.CountrylanguagePK[ countrycode="
				+ countrycode + ", language=" + language + " ]";
	}

}
