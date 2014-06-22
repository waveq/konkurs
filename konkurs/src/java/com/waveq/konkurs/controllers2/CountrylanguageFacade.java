/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waveq.konkurs.controllers2;

import com.waveq.konkurs.entity.Countrylanguage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Szymon
 */
@Stateless
public class CountrylanguageFacade extends AbstractFacade<Countrylanguage> {
    @PersistenceContext(unitName = "konkursPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountrylanguageFacade() {
        super(Countrylanguage.class);
    }
    
}
