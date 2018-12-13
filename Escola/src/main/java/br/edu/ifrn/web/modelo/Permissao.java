/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author joaon
 */
@Entity
public class Permissao {
    
    @Id
    private String nome;

    @Deprecated
    public Permissao() {
    }

    public Permissao(String nome) {
        this.nome = nome;
    }  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
