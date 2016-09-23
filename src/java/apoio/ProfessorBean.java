/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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

    /**
     * Creates a new instance of ProfessorBean
     */
    public ProfessorBean() {
        prof.setId(null);
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
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (prof.getId() == null) {
                //Salva os dados da pessoa.
                em.persist(prof);
            } else {
                //Atualiza os dados da pessoa.
                prof = em.merge(prof);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        prof = new Professor();
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

    public String excluir(Professor professor) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        professor = em.merge(professor);
        em.remove(professor);
        em.getTransaction().commit();
        em.close();

        this.professores = null;
        return "ListarProfessores";
    }
    public String alterar(Professor p){
        this.prof = p;
        return "CadastrarProfessor";
    }
}
