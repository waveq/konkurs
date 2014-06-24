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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Szymon
 */
@ManagedBean(name = "countrylanguageBean")
@SessionScoped
public class CountrylanguageController implements Serializable {

    @Inject
    CountrylanguageManager clm;
    
    @Inject
    CountryManager cm;
    Countrylanguage countrylanguage;

    public List getAllCountryLanguages() {
        List<Object[]> list = clm.findAllCountrylanguages();
        Long population = (Long) cm.getWholePopulation().get(0);
      double pop = population;
        for(int i=0; i<list.size();i++)
        {
            list.get(i)[2] = (Long)list.get(i)[2]/pop * 100;
        }
        return list;
    }

    public List getOfficialCountryLanguages() {
        return clm.findSortedOfficialCountrylanguages();

    }

    public List getCountrylanguageByCode(String code) {
        return clm.findCountryLanguagesByCode(code);
    }
}
