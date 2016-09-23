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
public class ExcluirProfessor {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Professor auto = em.getReference(Professor.class, 8L);
        tx.begin();
        em.remove(auto);
        tx.commit();
        em.close();
        PesquisarProfessor.main(args);

    }
}
