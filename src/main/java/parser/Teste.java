package parser;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		// Creating the config instance & passing the hibernate config file.
        Configuration config = new Configuration();
        config.configure("Hibernate.cfg.xml");
 
        // Session object to start the db transaction.
        Session s = config.buildSessionFactory().openSession();
 
        // Transaction object to begin the db transaction.
        Transaction t = s.beginTransaction();
         
        // Employee object.
		Fundo fundo = new Fundo("ticket", "nome", 1, 100);
        s.persist(fundo);
 
        // Committing the transaction in the db.
        t.commit();
         
        System.out.println("\n===================\n");
 
        // Query - To fetch all employees.
        List<Fundo> list = s.getNamedQuery("findFundos").getResultList();
 
        for(Fundo fund : list) {
            System.out.println(fund.toString());
        }
 
        // Closing the session object.
        s.close();
		
		
		
	}

}
