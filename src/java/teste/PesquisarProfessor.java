/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import apoio.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelos.Professor;

/**
 *
 * @author UsuarioGeral
 */
public class PesquisarProfessor {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        Query q = em.createQuery("select p from Professor p", Professor.class);
        List<Professor> autos = q.getResultList();
        for (Professor p : autos) {
            System.out.println(p.getNome());
        }
        em.close();
        JPAUtil.fechaEntityManager();

    }
}
