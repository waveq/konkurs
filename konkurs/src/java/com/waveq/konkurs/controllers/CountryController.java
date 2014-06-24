/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waveq.konkurs.controllers;

import com.waveq.konkurs.entity.Country;
import com.waveq.konkurs.entity.Countrylanguage;
import com.waveq.konkurs.service.CountryManager;
import com.waveq.konkurs.service.CountrylanguageManager;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Szymon
 */
@ManagedBean(name = "countryBean")
@SessionScoped
public class CountryController implements Serializable {
    
   @Inject
   CountryManager cm;
   
   @Inject
   CountrylanguageManager clm;
    
   Country country;
   List<Countrylanguage> languages;
    
    public String getCountryByCode(String code) {
        country = cm.find(code);
        languages = clm.findCountryLanguagesByCode(code);
        return country.getName();
    }
    
}
