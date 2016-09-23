/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import apoio.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelos.Professor;

/**
 *
 * @author UsuarioGeral
 */
public class IncluirProfessor {
    public static void main(String[] args) {
        
        EntityManager em = JPAUtil.getEntityManager();
        
        Professor prof = new Professor();
        prof.setNome("Ricardo Crepalde");
        prof.setTitulacao("Doutor");
        prof.setAnocontratacao(1994);
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(prof);
        tx.commit();
        em.close();
        
        PesquisarProfessor.main(args);

    }
}
