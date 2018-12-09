/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.bean;

import br.edu.ifrn.web.controle.DisControle;
import br.edu.ifrn.web.modelo.Disciplina;
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
public class DisBean {

    @Inject
    private DisControle disDAO;
    @Inject
    private Disciplina dismodel;
    @Inject
    private FacesContext facesContext;

    private List<Disciplina> listaDisciplina;

    private Integer idDisciplina;

    public List<Disciplina> getListaDisciplina() {
        return listaDisciplina;
    }

    public void setListaDisciplina(List<Disciplina> listaDisciplina) {
        this.listaDisciplina = listaDisciplina;
    }

    public DisControle getDisDAO() {
        return disDAO;
    }

    public void setDisDAO(DisControle disDAO) {
        this.disDAO = disDAO;
    }

    public Disciplina getDismodel() {
        return dismodel;
    }

    public void setDismodel(Disciplina dismodel) {
        this.dismodel = dismodel;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String salvarDis() {
        String path = "/disciplina/";
        String mensagem;

        if (dismodel.getId() != null) {
            disDAO.atualizar(dismodel);
            mensagem = "Disciplina atualizada com sucesso";
        } else {
            disDAO.salvar(dismodel);
            mensagem = "Disciplia salva com sucesso";
        }
        dismodel = new Disciplina();

        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(mensagem));

        return "disciplina.xhtml";

    }

    public void excluir(Disciplina disciplina) {
        disDAO.excluir(disciplina);
        disDAO = null;
    }

    public List<Disciplina> listarDis() {
        if (listaDisciplina == null) {
            listaDisciplina = disDAO.listar();
        }
        return listaDisciplina;
    }

    public String atualizar(Integer id) {
        return "curso.xhtml?id=" + String.valueOf(id);
    }

    public void carregarLivro() {
        if (idDisciplina != null) {
            Disciplina disciplina = disDAO.buscar(idDisciplina);
            if (disciplina != null) {
                this.dismodel = disciplina;
                return;
            }
        }
    }

}
