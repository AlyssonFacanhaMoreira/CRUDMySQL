/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.alysson.crud.mysql.database;

import com.mysql.jdbc.NonRegisteringDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alysson
 */
public class CreateConnection {
    
    private static final String HOST = "localhost";
    private static final String DATABASE = "crud";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() throws SQLException{
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to Database");
        return DriverManager.getConnection("jdbc:mysql://"+HOST+"/"+DATABASE, USER, PASSWORD);
        }catch(ClassNotFoundException e){
            throw new SQLException(e.getMessage());
        }
    
    }
}
