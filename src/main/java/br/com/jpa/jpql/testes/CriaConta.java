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
public class CriaConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager(); 
		
		Conta conta = new Conta();
		conta.setTitular("Renato");
		conta.setNumero(1234);
		conta.setAgencia(4321);
		/*Abrir transação */
		em.getTransaction().begin();
		/* persiste os dados */
		em.persist(conta);
		/*execulta transação */
		em.getTransaction().commit();
	}
}

