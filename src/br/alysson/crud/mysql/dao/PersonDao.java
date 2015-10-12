/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.alysson.crud.mysql.dao;

import br.alysson.crud.mysql.database.CreateConnection;
import br.alysson.crud.mysql.logic.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alysson
 */
public class PersonDao {
    
    private Connection connection;
    
    private final String TABLE = "people";
    
    public PersonDao() throws SQLException{
        this.connection = CreateConnection.getConnection();
    }
    
    public void create(Person person) throws SQLException{
        String sql = "INSERT INTO "+TABLE+" (name, phone, address) values (?, ?, ?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getPhone());
        preparedStatement.setString(3, person.getAddress());
        
        preparedStatement.execute();
        preparedStatement.close();
        
    }
    
    
    public List<Person> getPersonList() throws SQLException{
        String sql = "SELECT * FROM "+TABLE;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        List<Person> personList = new ArrayList<Person>();
     
        while(resultSet.next()){
            Person person = new Person();
            person.setId(Integer.parseInt(resultSet.getString("id")));
            person.setName(resultSet.getString("name"));
            person.setPhone(resultSet.getString("phone"));
            person.setAddress(resultSet.getString("address"));
            personList.add(person);
        }
     
        resultSet.close();
        preparedStatement.close();
        
        return personList;
    }
    
    
    public void update(Person person) throws SQLException{
        String sql = "UPDATE "+TABLE
                +" SET name=?, phone=?, address=?"
                + " where id=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getPhone());
        preparedStatement.setString(3, person.getAddress());
        preparedStatement.setLong(4, person.getId());
        
        preparedStatement.execute();
        preparedStatement.close();
    
    }
    
    public void delete(Person person) throws SQLException{
        String sql = "DELETE FROM "+TABLE+" WHERE id=?";
    
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, person.getId());
        
        preparedStatement.execute();
        preparedStatement.close();
        
    }
    
}
