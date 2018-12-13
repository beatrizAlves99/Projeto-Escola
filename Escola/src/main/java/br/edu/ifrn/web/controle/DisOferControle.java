/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.controle;

import br.edu.ifrn.web.modelo.Aluno;
import br.edu.ifrn.web.modelo.DisciplinaOfertada;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author beatriz
 */
public class DisOferControle {
     @PersistenceContext
    private EntityManager entityManeger;

     @Transactional
     public void salvar(DisciplinaOfertada disofer){
         entityManeger.persist(disofer);
     }
     
     @Transactional
     public void atualizar(DisciplinaOfertada disofer){
         entityManeger.persist(disofer);
     }
     
     public List<DisciplinaOfertada> listar() {
        String jpql = "select a from DisciplinaOfertada  a";
        return entityManeger.createQuery(jpql, DisciplinaOfertada.class).getResultList();
    }
     
     
     public DisciplinaOfertada buscar(Integer id){
        String jpql = "select distinct(a) from DisciplinaOfertada a  where a.id = :id";       
        return entityManeger.createQuery(jpql,DisciplinaOfertada.class).setParameter("id", id).getSingleResult();
    }
     @Transactional
    public void excluir(DisciplinaOfertada disofer) {
        entityManeger.remove(buscar(disofer.getId()));
    }
     
     
}
