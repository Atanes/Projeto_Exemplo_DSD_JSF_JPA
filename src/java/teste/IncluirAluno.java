/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import apoio.JPAUtil;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelos.Aluno;

/**
 *
 * @author UsuarioGeral
 */
public class IncluirAluno {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        Aluno aluno = new Aluno();

        aluno.setNome("Lenadro Zanolla");
        aluno.setCurso("Engenharia da Computação");
        aluno.setMatricula("876543");
        aluno.setNome("Gustavo da Costa e Silva");
        aluno.setCurso("Engenharia de Produção");
        aluno.setMatricula("123256");
        aluno.setDtaNascimento(new Date());

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(aluno);
        tx.commit();
        
        em.close();

    }
}
