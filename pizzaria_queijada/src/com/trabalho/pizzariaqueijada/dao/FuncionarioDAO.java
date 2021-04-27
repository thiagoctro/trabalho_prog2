package com.trabalho.pizzariaqueijada.dao;

import com.trabalho.pizzariaqueijada.ConnectionFactory;
import com.trabalho.pizzariaqueijada.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private Connection conn;

    public FuncionarioDAO(){
        conn = ConnectionFactory.getConnection();
    }

    public void salvarFuncionario(Funcionario f ){
        String sql = " INSERT INTO funcionarios (nome, endereco, senha) VALUES ( ?, ?, ? ) ";

        try(PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setString( 1, f.getNome() );
            stmt.setString( 2, f.getEndereco() );
            stmt.setString( 3, f.getSenha() );
            stmt.execute();

        } catch ( SQLException e){
            throw new RuntimeException( e );
        }
    }

    public void atualizarFuncionario( Funcionario f ){
        String sql  = "UPDATE funcionarios SET nome= ?, endereco= ?, senha= ? WHERE matricula= ? ";

        try( PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setString( 1, f.getNome() );
            stmt.setString( 2, f.getEndereco() );
            stmt.setString( 3, f.getSenha() );
            stmt.setInt( 4, f.getMatricula() );
            stmt.execute();

        } catch ( SQLException e ){
            throw new RuntimeException( e );
        }
    }

    public void removerFuncionario( Funcionario f ){
        String sql = "DELETE FROM funcionarios WHERE matricula= ?";

        try( PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setInt( 1, f.getMatricula() );
            stmt.execute();

        } catch ( SQLException e ){
            throw new RuntimeException( e );
        }
    }

    public List<Funcionario> getFuncionarios(){
        List<Funcionario> list = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";

        try( PreparedStatement stmt = conn.prepareStatement( sql );
             ResultSet rs = stmt.executeQuery() ){

            while ( rs.next() ){
                Funcionario f = new Funcionario(
                        rs.getInt( "matricula" ),
                        rs.getNString( "nome" ),
                        rs.getNString( "endereco" ),
                        rs.getNString( "senha" )
                );
                list.add( f );
            }

        } catch (SQLException e){
            throw new RuntimeException( e );
        }

        return list;
    }


}
