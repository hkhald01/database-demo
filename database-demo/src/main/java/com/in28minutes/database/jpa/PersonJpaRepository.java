/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in28minutes.database.jpa;

import com.in28minutes.database.entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dev
 */
@Repository
@Transactional

public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;
    
    public List<Person> findAll(){
       TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
       return namedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }
    public Person saveOrUpdate(Person person){
        return entityManager.merge(person);
    }
    public void deleteById(int id){
    Person person  = findById(id);
        entityManager.remove(person);
    }
}
