package br.estacio.modelo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    Connection conn;

    public FuncionarioDAO(){
        conn = ConnectionFactory.getConnection();
    }

    public void gravar(Funcionario f ){
        String sql = " INSERT INTO funcionarios VALUES ( ?, ?, ?, ?, ? ) ";

        try(PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setInt( 1, f.getMatricula() );
            stmt.setString( 2, f.getNome() );
            stmt.setString( 3, f.getEmail() );
            stmt.setDate( 4, Date.valueOf( f.getDt_nasc() ) );
            stmt.setString( 5, f.getSenha() );
            stmt.execute();

        } catch ( SQLException e){
            throw new RuntimeException( e );
        }
    }

    public void atualizar( Funcionario f ){
        String sql  = "UPDATE funcionarios SET nome = ?, email = ?, dt_nasc = ?, senha = ? WHERE matricula = ? ";

        try( PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setString( 1, f.getNome() );
            stmt.setString( 2, f.getEmail() );
            stmt.setDate( 3, Date.valueOf( f.getDt_nasc() ) );
            stmt.setString( 4, f.getSenha() );
            stmt.setInt( 5, f.getMatricula() );
            stmt.execute();

        } catch ( SQLException e ){
            throw new RuntimeException( e );
        }
    }

    public void apagar( Funcionario f ){
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
                        rs.getString( "nome" ),
                        rs.getString( "email" ),
                          rs.getDate( "dt_nasc" ).toLocalDate(),
                        rs.getString( "senha" )
                );
                list.add( f );
            }

        } catch (SQLException e){
            throw new RuntimeException( e );
        }

        return list;
    }

}
