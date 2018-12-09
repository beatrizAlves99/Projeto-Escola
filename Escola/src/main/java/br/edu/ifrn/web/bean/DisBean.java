/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.bean;

import br.edu.ifrn.web.controle.DisControle;
import br.edu.ifrn.web.modelo.Disciplina;
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

    private int idDisciplina;

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

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
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

}
