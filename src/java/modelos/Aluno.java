/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author Alexandre Atanes de Jesus
 * @since 27/09/2016
 * @version 1.0
 */
@Entity
public class Aluno extends Pessoa {

    private String matricula;
    private String Curso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtaNascimento;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
}
