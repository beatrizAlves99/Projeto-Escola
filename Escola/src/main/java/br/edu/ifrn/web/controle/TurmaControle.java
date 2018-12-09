/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.controle;

import br.edu.ifrn.web.modelo.Turma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author beatriz
 */
public class TurmaControle {
    @PersistenceContext
    private EntityManager entityManeger;
    
    @Transactional
    public void salvar(Turma turma){
    entityManeger.persist(turma);
    }
    
    @Transactional
    public void atualizar(Turma turma) {
        entityManeger.merge(turma);
    }

    public List<Turma> listar() {
        String jpql = "select a from Turma a";
        return entityManeger.createQuery(jpql, Turma.class).getResultList();
    }

     public Turma buscar(Integer id){
        String jpql = "select distinct(a) from Turma a  where a.id = :id";       
        return entityManeger.createQuery(jpql,Turma.class).setParameter("id", id).getSingleResult();
    }
     @Transactional
    public void excluir(Turma turma) {
        entityManeger.remove(buscar(turma.getId()));
    }
    
}
