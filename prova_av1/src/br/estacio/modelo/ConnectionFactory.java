package br.estacio.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(){
        String url = "jdbc:postgresql://localhost:5432/av1";
        String user = "postgres";
        String pass = ""; //senha do seu banco de dados

        try{
            return DriverManager.getConnection( url, user, pass );
        } catch ( SQLException e){
            throw new RuntimeException( e );
        }

    }

}
