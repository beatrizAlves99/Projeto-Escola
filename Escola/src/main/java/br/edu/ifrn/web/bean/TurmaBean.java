/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.bean;

import br.edu.ifrn.web.controle.CursoControle;
import br.edu.ifrn.web.controle.TurmaControle;
import br.edu.ifrn.web.modelo.Curso;
import br.edu.ifrn.web.modelo.Turma;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author beatriz
 */
@Model
public class TurmaBean {
    @Inject
    private TurmaControle turmaDAO;
    @Inject
    private CursoControle cursoDAO;
    @Inject
    private Turma turmamodel;
    @Inject
    private FacesContext facesContext;
    
    private List<Turma> listaTurma;
    private List<Curso> listacurso;
    
    private Integer idTurma;

    public TurmaControle getTurmaDAO() {
        return turmaDAO;
    }

    public void setTurmaDAO(TurmaControle turmaDAO) {
        this.turmaDAO = turmaDAO;
    }

    public Turma getTurmamodel() {
        return turmamodel;
    }

    public void setTurmamodel(Turma turmamodel) {
        this.turmamodel = turmamodel;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public List<Turma> getListaTurma() {
        return listaTurma;
    }

    public void setListaTurma(List<Turma> listaTurma) {
        this.listaTurma = listaTurma;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }
    
    public String salvarTurma() {
        String path = "/turma/";
        String mensagem;
        if (turmamodel.getId() != null) {
            turmaDAO.atualizar(turmamodel);
            mensagem = "Turma Atualizada com sucesso";
        } else {
            turmaDAO.salvar(turmamodel);
            mensagem = "Turma salvo com sucesso";
        }

        turmamodel = new Turma();
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
      //  facesContext.addMessage(null, new FacesMessage(mensagem));

        return "turma.xhtml";

    }

    public void excluirTurma(Turma turma) {
        turmaDAO.excluir(turma);
        turmaDAO = null;
    }

    public List<Turma> listarTurma() {
        if (listaTurma == null) {
            listaTurma = turmaDAO.listar();
        }
        return listaTurma;
    }
    
    public List<Curso> listarCurso() {
        if (listacurso == null) {
            listacurso = cursoDAO.listar();
        }
        return listacurso;
    }
    
    public String atualizar(Integer id){
        return "turma.xhtml?id=" + String.valueOf(id);
    }
    
    
    public void carregarLivro(){
        if (idTurma != null){
            Turma turma = turmaDAO.buscar(idTurma);
            if (turma != null){
                this.turmamodel = turma;
                return;
            }
        }             
    }
    
}
