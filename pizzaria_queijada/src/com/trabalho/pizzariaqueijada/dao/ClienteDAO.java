package com.trabalho.pizzariaqueijada.dao;

import com.trabalho.pizzariaqueijada.ConnectionFactory;
import com.trabalho.pizzariaqueijada.model.Cliente;

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

}
