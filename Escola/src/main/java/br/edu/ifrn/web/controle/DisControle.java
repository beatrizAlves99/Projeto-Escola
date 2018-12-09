/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.controle;

import br.edu.ifrn.web.modelo.Disciplina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author beatriz
 */
public class DisControle {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void salvar(Disciplina disciplina){
        entityManager.persist(disciplina);
    }
    @Transactional
    public void atualizar(Disciplina disciplina){
        entityManager.merge(disciplina);
    }
    
    public List<Disciplina> listar() {
        String jpql = "select a from Disciplina a";
        return entityManager.createQuery(jpql, Disciplina.class).getResultList();
    }

     public Disciplina buscar(Integer id){
        String jpql = "select distinct(a) from Disciplina a  where a.id = :id";       
        return entityManager.createQuery(jpql,Disciplina.class).setParameter("id", id).getSingleResult();
    }
     @Transactional
    public void excluir(Disciplina disciplina) {
        entityManager.remove(buscar(disciplina.getId()));
    }
    
    
    
    
}
