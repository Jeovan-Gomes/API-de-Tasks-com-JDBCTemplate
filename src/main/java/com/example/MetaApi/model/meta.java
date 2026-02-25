package com.example.MetaApi.model;

import java.util.Date;

public class meta {

    private int id;
    private String titulo;
    private String descricao;
    private Date prazo;
    private String status;

    public meta(int id, String titulo, String descricao, Date prazo, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.status = status;
    }

    public meta(String titulo, String descricao, Date prazo, String status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.status = status;
    }

    public meta(){

    }

    public int getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getDescricao(){
        return descricao;
    }
    public Date getPrazo(){
        return prazo;
    }
    public String getStatus(){
        return status;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setPrazo(Date prazo){
        this.prazo = prazo;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
