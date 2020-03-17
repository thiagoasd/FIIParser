package parser;

import java.util.ArrayList;
import java.util.HashSet;
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

		System.out.println("\n===================\n");

		HTMLParser parser = new HTMLParser("https://fiis.com.br/lista-de-fundos-imobiliarios/");

		// parser.getCotacoes();
		List<Cotacao> cotacoes = parser.getFundos2();
		
		cotacoes = new ArrayList<Cotacao>(new HashSet<Cotacao>(cotacoes));

		for (Cotacao cotacao : cotacoes) {
			s.persist(cotacao);
			t.commit();
			s.beginTransaction();
			
		}

		// Committing the transaction in the db.
		//t.commit();

		// Closing the session object.
		s.close();

	}

}
