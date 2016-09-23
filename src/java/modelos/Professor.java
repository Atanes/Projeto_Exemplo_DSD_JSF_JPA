/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author UsuarioGeral
 */
@javax.persistence.Entity
public class Professor implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String titulacao;
    private Integer anoContratacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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
