package com.trabalho.pizzariaqueijada.model;

public class Produto {

    private int codigo;
    private String produto;
    private double precoUnitario;

    public Produto() {
    }

    public Produto(int codigo, String produto, double precoUnitario) {
        this.codigo = codigo;
        this.produto = produto;
        this.precoUnitario = precoUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
