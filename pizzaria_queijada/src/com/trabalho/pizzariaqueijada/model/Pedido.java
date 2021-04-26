package com.trabalho.pizzariaqueijada.model;

import java.time.LocalDate;

public class Pedido {

    private int codigo;
    private Cliente cliente;
    private Funcionario funcionario;
    private LocalDate dataPedido;
    private Double valorTotal;

    public Pedido() {
    }

    public Pedido(int codigo, Cliente cliente, Funcionario funcionario, LocalDate dataPedido, Double valorTotal) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }


}
