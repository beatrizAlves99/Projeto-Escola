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
    
    public List<Curso> listarCurso(){
        return entityManager.createQuery("from curso").getResultList();
    }
    
    public void atualizarCurso(Curso curso){
        entityManager.merge(curso);
    }
    
    public void excluirCurso(Curso curso){
        entityManager.remove(curso);
    }
    
}
