package br.com.jpa.jpql.testes;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Renato
 *
 */
public class CriaTabelaConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		emf.close();
	}
}
