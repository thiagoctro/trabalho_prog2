package com.trabalho.pizzariaqueijada;

import com.trabalho.pizzariaqueijada.dao.ClienteDAO;
import com.trabalho.pizzariaqueijada.dao.FuncionarioDAO;
import com.trabalho.pizzariaqueijada.dao.ProdutoDAO;
import com.trabalho.pizzariaqueijada.model.Cliente;
import com.trabalho.pizzariaqueijada.model.Funcionario;
import com.trabalho.pizzariaqueijada.model.Produto;


public class MainClass {

    public static void main(String[] args){


        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.getProduto( 1001 );

        System.out.println( produto.toString() );

    }

}
