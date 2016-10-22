/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javax.persistence.Entity;

/**
 *
 * @author UsuarioGeral
 */
@Entity
public class Professor extends Pessoa {
    
    private String titulacao;
    private Integer anoContratacao;

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public Integer getAnocontratacao() {
        return anoContratacao;
    }

    public void setAnocontratacao(Integer anoContratacao) {
        this.anoContratacao = anoContratacao;
    }
    
}
