package br.com.jpa.jpql.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.jpql.modelo.Conta;

/**
 * 
 * @author Renato
 *
 */
public class TestandoEstados {
	public static void main(String[] args) {
		/*
		 * Estados da conta Transient para Managed e de Managed para Removed
		 */
		// Transient
		Conta conta = new Conta();
		conta.setTitular("Renato");
		conta.setAgencia(123);
		conta.setNumero(321);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		// Transient -> Managed
		em.persist(conta);

		// Managed -> Removed
		em.remove(conta);

		em.getTransaction().commit();
		em.close();
	}

}
