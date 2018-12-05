/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author beatriz
 */
@Entity
public class Disciplina implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeDis;
    private long cargHor;
    
   // private List<Disciplina> dependencias;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDis() {
        return nomeDis;
    }

    public void setNomeDis(String nomeDis) {
        this.nomeDis = nomeDis;
    }

    

    public long getCargHor() {
        return cargHor;
    }

    public void setCargHor(long cargHor) {
        this.cargHor = cargHor;
    }

    /*public List<Disciplina> getDependencias() {
        return dependencias;
    }

    public void setDependencias(List<Disciplina> dependencias) {
        this.dependencias = dependencias;
    }*/
    
    
    
    
    
}
