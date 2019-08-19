package com.in28minutes.database;

import com.in28minutes.database.jdbc.PersonJdbcDao;
import com.in28minutes.database.entity.Person;
import java.util.Date;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class DatabaseJDBCDemoApplication implements CommandLineRunner {
Logger logger =LoggerFactory.getLogger(this.getClass());
@Autowired
private PersonJdbcDao dao;
    
    public static void main(String[] args) {
		SpringApplication.run(DatabaseJDBCDemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    /*
       logger.info("All users -> {}",dao.findAll());
       logger.info("User id 10001 -> {}",dao.findById(10001));
       logger.info("User Name Ranga -> {}",dao.findByName("Ranga"));
       logger.info("deleteing user with id 5001 -> {}",dao.deleteById(5001));
       logger.info("deleteing user with id 5002 -> {}",dao.deleteById(5002));
       logger.info("Inserting 10004 - >{}",dao.insert(new Person(10004,"Tara","Berlin",new Date())));
       logger.info("Updating  10003   ->{}",dao.update(new Person(10003,"Pieter","Utrecht",new Date())));
*/
    }

}
