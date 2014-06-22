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
    Countrylanguage countrylanguage;

    public List getAllCountryLanguages() {
        List list = clm.findAllCountrylanguages();
        return list;
    }

    public List getOfficialCountryLanguages() {
        return clm.findSortedOfficialCountrylanguages();

    }

}
