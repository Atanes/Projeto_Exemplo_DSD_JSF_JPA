/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelos.Professor;

/**
 *
 * @author Alexandre Atanes de Jesus
 * @data 10/09/2016
 */
@ManagedBean
@SessionScoped
public class ProfessorBean {

    private Professor prof = new Professor();
    private List<Professor> professores;
    private UIComponent panelForm;

    /**
     * Creates a new instance of ProfessorBean
     */
    public ProfessorBean() {
        prof.setId(null);
    }

    public void setPanelForm(UIComponent panelForm) {
        this.panelForm = panelForm;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            System.out.println("Salvando a pessoa.");
            System.out.println(prof.getNome());
            //System.out.println(prof.getId());
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (prof.getId() == null) {
                //Salva os dados da pessoa.
                em.persist(prof);
                System.out.println("NOVO");
            } else {
                //Atualiza os dados da pessoa.
                prof = em.merge(prof);
                System.out.println("VELHO");
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        this.professores = null;
        return "ListarProfessores";
    }

    public List<Professor> getProfessores() {

        if (this.professores == null) {
            EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("select a from Professor a",
                    Professor.class);
            this.professores = q.getResultList();
            em.close();
        }
        return professores;
    }

    public void excluir(Professor professor) {

        if (professor.getId() != null) {
            EntityManager em = JPAUtil.getEntityManager();

            System.out.println(professor.getId() + ", " + professor.getNome());
            em.getTransaction().begin();
            //professor = em.find(Professor.class, professor.getId());
            professor = em.merge(professor);
            em.remove(professor);
            em.getTransaction().commit();
            em.close();
        }

        this.professores = null;
        //return "ListarProfessores";

    }

    public String alterar(Professor p) {
        this.prof = p;
        return "CadastrarProfessor";
    }

    public String cadastrarNovo() {
        prof = new Professor();
        return "CadastrarProfessor";
    }
}
