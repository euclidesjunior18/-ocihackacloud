package com.youhungry.endpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(length = 60, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String nome;
    @Column
    private String endereco;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String cep;


}
