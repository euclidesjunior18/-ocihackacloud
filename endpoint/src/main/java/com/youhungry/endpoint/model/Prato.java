package com.youhungry.endpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Prato {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long idprato;

    @Column(length = 40, nullable = false)
    private String nome;
    @Column(length = 90, nullable = false)
    private String descricao;
    @OneToOne
    @JoinColumn(name = "idrestaurante",nullable=false)
    private Restaurante restaurante;
    @Column @Temporal(TemporalType.TIME) // HH:mm:ss
    private Date tempoParaPreparo;
    @Column
    private String acompanhamento;
    @Column
    private double preco;
    @Column
    private String url;

    public Prato(String nome, String descricao, Restaurante restaurante) {
        this.nome = nome;
        this.descricao = descricao;
        this.restaurante = restaurante;
    }

    public long getIdprato() {
        return idprato;
    }

    public void setIdprato(int idprato) {
        this.idprato = idprato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Date getTempoParaPreparo() {
        return tempoParaPreparo;
    }

    public void setTempoParaPreparo(Date tempoParaPreparo) {
        this.tempoParaPreparo = tempoParaPreparo;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
