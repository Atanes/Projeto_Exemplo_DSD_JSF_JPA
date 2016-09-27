/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import apoio.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelos.Escola;

/**
 *
 * @author UsuarioGeral
 */
public class IncluirEscola {
    public static void main(String[] args) {
        
        EntityManager em = JPAUtil.getEntityManager();
        
        Escola escola = new Escola();
        escola.setNome("Escola de Engenharia");
        escola.setLocalizacao("Rudge Ramos");
        escola.setAnoCriacao(2015);
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(escola);
        tx.commit();
        em.close();
        
        PesquisarProfessor.main(args);

    }
}
