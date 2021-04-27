package com.trabalho.pizzariaqueijada;

import com.trabalho.pizzariaqueijada.dao.FuncionarioDAO;
import com.trabalho.pizzariaqueijada.model.Funcionario;

import java.sql.Connection;

public class MainClass {

    public static void main(String[] args){

       Funcionario funcionario = new Funcionario( 104, "Thiago", "Rua abc, 123", "123456" );

       FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
       funcionarioDAO.removerFuncionario( funcionario );

    }

}
