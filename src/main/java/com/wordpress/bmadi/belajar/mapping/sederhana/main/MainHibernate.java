/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.bmadi.belajar.mapping.sederhana.main;

import com.wordpress.bmadi.belajar.mapping.sederhana.model.HibernateUtil;
import com.wordpress.bmadi.belajar.mapping.sederhana.model.Person;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author madiandi
 */
public class MainHibernate {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Person p = new Person();
        p.setName("Madi Andi");
        p.setPassword("password madi andi");
        session.save(p);

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        Query query = session.createQuery("from Person");
        List<Person> persons = query.list();
        for (Person person : persons) {
            System.out.println("id : " + person.getId());
            System.out.println("name : " + person.getName());
            System.out.println("password : " + person.getPassword());

        }
        session.close();

    }

}
