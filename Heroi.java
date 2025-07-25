package com.example.dota_api.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Heroi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ElementCollection
    private List<String> posicoes;

    @ElementCollection
    private List<String> habilidades;

    public Heroi() {

    }

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

    public List<String> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(List<String> posicoes) {
        this.posicoes = posicoes;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
