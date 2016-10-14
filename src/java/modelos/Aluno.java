/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Alexandre Atanes de Jesus
 * @since 27/09/2016
 * @version 1.0
 */
@Entity
public class Aluno implements Serializable {

    @Id
    private String matricula;
    private String nome;
    private String Curso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtaNascimento;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public Date getDtaNascimento() {
        return dtaNascimento;
    }

    public void setDtaNascimento(Date dtaNascimento) {

        this.dtaNascimento = dtaNascimento;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.matricula);
        hash = 43 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

}
