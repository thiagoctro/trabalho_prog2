package br.estacio.modelo.test;

import br.estacio.modelo.Funcionario;
import br.estacio.modelo.FuncionarioDAO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TestaFuncionario {

    public static void main(String[] args) {
        //criando funcionarios para teste
        Funcionario funcionario1 = new Funcionario(
                101,
                " Guilherme Saraiva ",
                "guilhermesgc@gmail.com",
                LocalDate.now(),
                "123456"
        );

        Funcionario funcionario2 = new Funcionario(
                102,
                " Camila Castro ",
                "ccamilacs@gmail.com",
                LocalDate.now(),
                "123abc"
        );

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        /* gravando funcionarios no banco de dados */
       // funcionarioDAO.gravar( funcionario1 );
        // funcionarioDAO.gravar( funcionario2 );

        /* atualizar funcionario  */
        //funcionario1.setNome( "Thiago Castro" );
        //funcionario1.setEmail( "thiagoctr3@gmail.com" );
       // funcionarioDAO.atualizar( funcionario1 );

        /* apagar funcionario */
        //funcionarioDAO.apagar( funcionario2 );

        /* Listar funcionarios */
        //List<Funcionario> funcionarioList = funcionarioDAO.getFuncionarios();
        //System.out.println( funcionarioList.toString() );

    }

}
