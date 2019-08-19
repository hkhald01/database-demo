/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in28minutes.database.jdbc;

import com.in28minutes.database.entity.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dev
 */
@Repository
public class PersonJdbcDao {
    
    class PersonRowMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet rs, int i) throws SQLException {
           
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setLocation(rs.getString("location"));
                person.setBirthDate(rs.getTimestamp("birth_date"));
           
           return person;
        }
        
    }
    
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    javax.sql.DataSource dataSource;
    
    public List<Person> findAll(){

        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
       // return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }
    public Person findById(int id){
        //return jdbcTemplate.queryForObject("select * from person where id=?",new Object[]{id},new BeanPropertyRowMapper<Person>(Person.class));
        return jdbcTemplate.queryForObject("select * from person where id=?",new Object[]{id},new PersonRowMapper());
    }
     public List<Person> findByName(String name){
        //return jdbcTemplate.query("select * from person where name=?",new Object[]{name},new BeanPropertyRowMapper<Person>(Person.class));
        return jdbcTemplate.query("select * from person where name=?",new Object[]{name},new PersonRowMapper());
    }
      public int deleteById(int id){
       return jdbcTemplate.update("delete from person where id=?",new Object[]{id});
    }
    public int insert (Person person){//(id,name,location,birth_date)
          return jdbcTemplate.update("insert into person values (?,?,?,?)",new Object[]{person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())});
          
    }
     public int update (Person person){
          return jdbcTemplate.update("update person set name= ? ,location = ? ,birth_date = ? where id = ?",new Object[]{person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime()),person.getId()});
    }
}
