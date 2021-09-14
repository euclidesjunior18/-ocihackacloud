package com.youhungry.endpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Restaurante {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long idrestaurante;

    @Column(length = 60, nullable = false)
    private String nome;
    @Column(length = 30, nullable = false)
    private String password;
    @Column(length = 80)
    private String especialidade;
    @Column(length = 80)
    private String endereco;
    @Column(length = 40)
    private String cidade;
    @Column(length = 20)
    private String cep;
    @Column(length = 40, nullable = false)
    private String cnpj;

    public Restaurante(String nome, String password, String cnpj) {
        this.nome = nome;
        this.password = password;
        this.cnpj = cnpj;
    }

    public long getIdrestaurante() {
        return idrestaurante;
    }

    public void setIdrestaurante(int idrestaurante) {
        this.idrestaurante = idrestaurante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
