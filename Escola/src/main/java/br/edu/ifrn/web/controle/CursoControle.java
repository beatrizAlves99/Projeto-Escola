/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.controle;

import br.edu.ifrn.web.modelo.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author beatriz
 */
public class CursoControle {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void salvarCurso(Curso curso){
        entityManager.persist(curso);
    }
    
    @Transactional
    public void atualizar(Curso curso) {
        entityManager.merge(curso);
    }

    public List<Curso> listar() {
        String jpql = "select a from Curso a";
        return entityManager.createQuery(jpql, Curso.class).getResultList();
    }

     public Curso buscar(Integer id){
        String jpql = "select distinct(a) from Curso a  where a.id = :id";       
        return entityManager.createQuery(jpql,Curso.class).setParameter("id", id).getSingleResult();
    }
     @Transactional
    public void excluir(Curso curso) {
        entityManager.remove(buscar(curso.getId()));
    }
    
}
