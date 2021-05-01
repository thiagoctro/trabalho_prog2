package com.trabalho.pizzariaqueijada.dao;

import com.trabalho.pizzariaqueijada.ConnectionFactory;
import com.trabalho.pizzariaqueijada.model.Cliente;
import com.trabalho.pizzariaqueijada.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Connection conn;

    public ClienteDAO(){
        conn = ConnectionFactory.getConnection();
    }

    public void salvarCliente(Cliente c){
        String sql = " INSERT INTO Clientes (codigo, nome, endereco, telefone) VALUES ( ?, ?, ?, ? ) ";

        try(PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setInt( 1, c.getCodigo() );
            stmt.setString( 2, c.getNome() );
            stmt.setString( 3, c.getEndereco() );
            stmt.setString( 4, c.getTel() );
            stmt.execute();

        } catch ( SQLException e){
            throw new RuntimeException( e );
        }
    }

    public void atualizarCliente( Cliente c ){
        String sql  = "UPDATE clientes SET nome= ?, endereco= ?, telefone= ? WHERE codigo= ? ";

        try( PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setString( 1, c.getNome() );
            stmt.setString( 2, c.getEndereco() );
            stmt.setString( 3, c.getTel() );
            stmt.setInt( 4, c.getCodigo() );
            stmt.execute();

        } catch ( SQLException e ){
            throw new RuntimeException( e );
        }
    }

    public void removerCliente( Cliente c ){
        String sql = "DELETE FROM clientes WHERE codigo= ?";

        try( PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setInt( 1, c.getCodigo() );
            stmt.execute();

        } catch ( SQLException e ){
            throw new RuntimeException( e );
        }
    }

    public List<Cliente> getClientes(){
        List<Cliente> list = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try( PreparedStatement stmt = conn.prepareStatement( sql );
             ResultSet rs = stmt.executeQuery() ){

            while ( rs.next() ){
                Cliente c = new Cliente(
                        rs.getInt( "codigo" ),
                        rs.getNString( "nome" ),
                        rs.getNString( "endereco" ),
                        rs.getNString( "telefone" )
                );
                list.add( c );
            }

        } catch (SQLException e){
            throw new RuntimeException( e );
        }

        return list;
    }

    public Cliente getCliente( int codigo ){
        String sql = "SELECT * FROM clientes WHERE codigo = ? ";
        Cliente c = new Cliente();

        try( PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setInt(1, codigo );
            ResultSet rs = stmt.executeQuery();

            if ( rs.next() ){
                c.setCodigo( rs.getInt( "codigo" ) );
                c.setNome( rs.getString( "nome" ) );
                c.setEndereco( rs.getString( "endereco" ) );
                c.setTel( rs.getString( "tel" ) );
            }
            rs.close();

        } catch ( SQLException e ){
            throw new RuntimeException( e );
        }
        return c;
    }

}
