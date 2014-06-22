/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waveq.konkurs.service;

import com.waveq.konkurs.entity.Country;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Szymon
 */
@Stateless
public class CountryManager {

    @PersistenceContext
    EntityManager em;

    public Country find(char i) {
        return em.find(Country.class, i);
    }

    public List findAllCountries() {
        return em.createNamedQuery("Country.findAll").getResultList();
    }
}
