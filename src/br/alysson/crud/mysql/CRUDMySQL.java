/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.alysson.crud.mysql;

import br.alysson.crud.mysql.dao.PersonDao;
import br.alysson.crud.mysql.logic.Person;
import java.sql.SQLException;

/**
 *
 * @author Alysson
 */
public class CRUDMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        // TODO code application logic here
        //System.out.println("Hello World!");
        //Connection connection = CreateConnection.getConnection();
        //connection.close();
        //System.out.println("Closing connection");
        
        Person person = new Person();
        person.setId(4);
        
        /*
        person.setName("Isael");
        person.setPhone("(85)98648-8515");
        person.setAddress("Rua Mestre Evangelista");
        person.setId(3);
        */
                
        PersonDao personDao = new PersonDao();
        //personDao.create(person);
        //personDao.update(person);
        //personDao.delete(person);
        
        /*
        List<Person> people = personDao.getPersonList();
        
        System.out.println("---------------------------------------------");
        for(Person p : people){
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getPhone());
            System.out.println(p.getAddress());
            System.out.println("---------------------------------------------");
        }
        */
        
    }
    
}
