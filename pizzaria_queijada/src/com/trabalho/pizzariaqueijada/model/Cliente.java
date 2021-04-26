package com.trabalho.pizzariaqueijada.model;

public class Cliente {

    private int codigo;
    private String nome;
    private String endereco;
    private String tel;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String endereco, String tel) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.tel = tel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
