/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.bean;

;
import br.edu.ifrn.web.controle.AlunoControle;
import br.edu.ifrn.web.modelo.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 *
 * @author beatriz
 */


@Model
public class AlunoBean {

    @Inject
    private AlunoControle alunoDao;
    @Inject
    private Aluno alunomodel;
    @Inject
    private FacesContext facesContext;

    private List<Aluno> listaAluno;

    private Part fotoaluno;

    private Integer idbean;

    public AlunoControle getAlunoDao() {
        return alunoDao;
    }

    public void setAlunoDao(AlunoControle alunoDao) {
        this.alunoDao = alunoDao;
    }

    public Aluno getAlunomodel() {
        return alunomodel;
    }

    public void setAlunomodel(Aluno alunomodel) {
        this.alunomodel = alunomodel;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public Integer getIdbean() {
        return idbean;
    }

    public void setIdbean(Integer idbean) {
        this.idbean = idbean;
    }

    
    public Part getFotoaluno() {
        return fotoaluno;
    }

    public void setFotoaluno(Part fotoaluno) {
        this.fotoaluno = fotoaluno;
    }

    public List<Aluno> getListaAluno() {
        return listaAluno;
    }

    public void setListaAluno(List<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }

    public String salvarAluno() {
        String path = "/aluno/";
        String mensagem;
        if (alunomodel.getId() != null) {
            alunoDao.atualizar(alunomodel);
            mensagem = "Aluno Atualizado com suceso";
        } else {
            alunoDao.salvar(alunomodel);
            mensagem = "Aluno salvo com sucesso";
        }

        alunomodel = new Aluno();
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(mensagem));

        return "aluno.xhtml";

    }

    public void excluirAluno(Aluno aluno) {
        alunoDao.excluir(aluno);
        alunoDao = null;
    }

    public List<Aluno> listarAluno() {
        if (listaAluno == null) {
            listaAluno = alunoDao.listar();
        }
        return listaAluno;
    }
    
    
    public String atualizar(Integer id){
        return "aluno.xhtml?id=" + String.valueOf(id);
    }
    
    
    public void carregarLivro(){
        if (idbean != null){
            Aluno aluno = alunoDao.buscar(idbean);
            if (aluno != null){
                this.alunomodel = aluno;
                return;
            }
        }             
    }
}
