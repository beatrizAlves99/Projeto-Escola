/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.controle;

import br.edu.ifrn.web.modelo.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author beatriz
 */
public class AlunoControle {

    @PersistenceContext
    private EntityManager entityManeger;

    @Transactional
    public void salvar(Aluno aluno) {
        entityManeger.persist(aluno);
    }
    @Transactional
    public void atualizar(Aluno aluno) {
        entityManeger.merge(aluno);
    }


     public List<Aluno> listar(){
        String jpql = "select distinct(l) from Aluno ";
        return entityManeger.createQuery(jpql,Aluno.class).getResultList();
    }
   /* public void buscar(Integer id){
        entityManeger.find(type, aluno)
    }*/

    public void excluir(Aluno aluno){
        entityManeger.remove(aluno);
    }
    
}
