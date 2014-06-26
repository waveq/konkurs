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
        Double population = (Double) clm.getWholePopulation().get(0);
        double pop = population;
        System.out.println(pop);
        for (Object[] list1 : list) {
            list1[2] = (Double) list1[2] / pop * 10000;
        }
        return list;
    }

    public List getOfficialCountryLanguages() {
        List<Object[]> l = clm.findSortedOfficialCountrylanguages();
        for (Object[] list1 : l) {
            list1[5] = (Integer) list1[5] * (Float) list1[4] * 0.01;
        }
        return l;
    }

    public List getCountrylanguageByCode(String code) {
        return clm.findCountryLanguagesByCode(code);
    }

    public String getCountryByCode(String code) {
        return cm.find(code).getName();
    }
}
