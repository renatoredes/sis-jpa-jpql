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
public class AlteraSaldoContaRenato {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		// find busca registro no banco
		Conta contaDoLeonardo = em.find(Conta.class, 1L);
		
		em.getTransaction().begin();
		// Estado Managed sicronização automaticamente  no banco
		contaDoLeonardo.setSaldo(20.0);
		
		em.getTransaction().commit();
		
	}
}
