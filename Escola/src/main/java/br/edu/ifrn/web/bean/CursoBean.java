/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.bean;

import br.edu.ifrn.web.controle.CursoControle;
import br.edu.ifrn.web.modelo.Curso;
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
public class CursoBean {

    @Inject
    private CursoControle cursoDAO;
    @Inject
    private Curso cursomodel;
    @Inject
    private FacesContext facesContext;
    
    private List<Curso> listaCurso;

    private Integer idbeanCurso;

    public CursoControle getCursoDAO() {
        return cursoDAO;
    }

    public void setCursoDAO(CursoControle cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public Curso getCursomodel() {
        return cursomodel;
    }

    public void setCursomodel(Curso cursomodel) {
        this.cursomodel = cursomodel;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public Integer getIdbeanCurso() {
        return idbeanCurso;
    }

    public void setIdbeanCurso(Integer idbeanCurso) {
        this.idbeanCurso = idbeanCurso;
    }

    public List<Curso> getListaCurso() {
        return listaCurso;
    }

    public void setListaCurso(List<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }
    
    

    public String salvarCurso() {
        String path = "/curso/";
        String mensagem;

        if (cursomodel.getId() != null) {
            cursoDAO.atualizar(cursomodel);
            mensagem = "Curso Atuaizado com sucesso";
        } else {
            cursoDAO.salvarCurso(cursomodel);
            mensagem = "Curso Salvo com sucesso";
        }
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(mensagem));
        return "curso.xhtml";
    }
    
    public void excluir(Curso curso) {
        cursoDAO.excluir(curso);
        cursoDAO = null;
    }

    public List<Curso> listarCurso() {
        if (listaCurso == null) {
            listaCurso = cursoDAO.listar();
        }
        return listaCurso;
    }
    
    
    public String atualizar(Integer id){
        return "curso.xhtml?id=" + String.valueOf(id);
    }
    
    
    public void carregarLivro(){
        if (idbeanCurso != null){
            Curso curso = cursoDAO.buscar(idbeanCurso);
            if (curso != null){
                this.cursomodel = curso;
                return;
            }
        }             
    }

}
