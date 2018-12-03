/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.utils;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author beatriz
 */
public class CriarFacesContext {
    @Produces
    @RequestScoped
    public javax.faces.context.FacesContext getFacesContext(){
        return javax.faces.context.FacesContext.getCurrentInstance();
    }
}
