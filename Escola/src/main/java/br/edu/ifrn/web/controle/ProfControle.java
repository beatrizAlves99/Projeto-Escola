/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.controle;

import br.edu.ifrn.web.modelo.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author beatriz
 */
public class ProfControle {
    @PersistenceContext
    private EntityManager entityManeger;
    
    @Transactional
    public void salvar(Professor professor){
    entityManeger.persist(professor);
    }
    
    @Transactional
    public void atualizar(Professor professor) {
        entityManeger.merge(professor);
    }

    public List<Professor> listar() {
        String jpql = "select a from Professor a";
        return entityManeger.createQuery(jpql, Professor.class).getResultList();
    }

     public Professor buscar(Integer id){
        String jpql = "select distinct(a) from Professor a  where a.id = :id";       
        return entityManeger.createQuery(jpql,Professor.class).setParameter("id", id).getSingleResult();
    }
     @Transactional
    public void excluir(Professor professor) {
        entityManeger.remove(buscar(professor.getId()));
    }
    
}
