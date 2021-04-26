package com.trabalho.pizzariaqueijada.model;

public class Funcionario {

    private int matricula;
    private String nome;
    private String endereco;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(int matricula, String nome, String endereco, String senha) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.senha = senha;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean logar( int matricula, String senha ) {
        return true;
    }

}
