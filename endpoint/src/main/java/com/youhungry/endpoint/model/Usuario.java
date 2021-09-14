package com.youhungry.endpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long idusuario;

    @Column(length = 60, nullable = false)
    private String email;
    @Column(length = 30, nullable = false)
    private String password;
    @Column(length = 60, nullable = false)
    private String nome;
    @Column
    private String endereco;
    @Column
    private String cidade;
    @Column
    private String cep;

    public Usuario(String email, String password, String nome) {
        this.email = email;
        this.password = password;
        this.nome = nome;
    }

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
