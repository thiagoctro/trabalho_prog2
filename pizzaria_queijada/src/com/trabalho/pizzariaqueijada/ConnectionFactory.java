package com.trabalho.pizzariaqueijada;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(){

        String url = "jdbc:postgresql://localhost:5432/pizzaria_queijada";
        String user = "postgres";
        String pass = "Ctr@2020";

        try {
            return DriverManager.getConnection( url, user, pass );
        } catch ( SQLException e){
            throw new RuntimeException();
        }

    }


}
