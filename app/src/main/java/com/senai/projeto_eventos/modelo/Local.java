package com.senai.projeto_eventos.modelo;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Local implements Serializable {

    private int id;
    private String descricao;
    private String bairro;
    private String cidade;

    public Local(int id, String descricao, String bairro, String cidade) {
        this.id = id;
        this.descricao = descricao;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @NonNull
    @Override
    public String toString() {
        return descricao;
    }
}
