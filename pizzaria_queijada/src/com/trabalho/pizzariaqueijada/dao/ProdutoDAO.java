package com.trabalho.pizzariaqueijada.dao;

import com.trabalho.pizzariaqueijada.ConnectionFactory;
import com.trabalho.pizzariaqueijada.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    Connection conn;

    public ProdutoDAO(){
        conn = ConnectionFactory.getConnection();
    }

    public void salvarProduto(Produto p){
        String sql = " INSERT INTO produtos (codigo, nome, preco) VALUES ( ?, ?, ? ) ";

        try(PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setInt( 1, p.getCodigo());
            stmt.setString( 2, p.getNome() );
            stmt.setDouble( 3, p.getPrecoUnitario() );
            stmt.execute();

        } catch ( SQLException e){
            throw new RuntimeException( e );
        }
    }

    public void atualizarProduto( Produto p ){
        String sql  = "UPDATE produtos SET nome= ?, preco= ? WHERE codigo= ? ";

        try( PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setString( 1, p.getNome() );
            stmt.setDouble( 2, p.getPrecoUnitario() );
            stmt.setInt( 3, p.getCodigo() );
            stmt.execute();

        } catch ( SQLException e ){
            throw new RuntimeException( e );
        }
    }

    public void removerProduto( Produto p ){
        String sql = "DELETE FROM produtos WHERE codigo = ?";

        try( PreparedStatement stmt = conn.prepareStatement( sql ) ){

            stmt.setInt( 1, p.getCodigo() );
            stmt.execute();

        } catch ( SQLException e ){
            throw new RuntimeException( e );
        }
    }

    public List<Produto> getProdutos(){
        List<Produto> list = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try( PreparedStatement stmt = conn.prepareStatement( sql );
             ResultSet rs = stmt.executeQuery() ){

            while ( rs.next() ){
                Produto p = new Produto(
                        rs.getInt( "codigo" ),
                        rs.getNString( "nome" ),
                        rs.getDouble( "preco" )
                );
                list.add( p );
            }

        } catch (SQLException e){
            throw new RuntimeException( e );
        }

        return list;
    }

}
