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
public class CriaContaComSaldo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager(); 
		
		Conta conta = new Conta();
		conta.setTitular("Ferreira");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(500.0);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close(); // fechou a conta agora o
		
		// Estado é Detached não há sicronização automatica
		EntityManager em2 = emf.createEntityManager();
		System.out.println("ID da Conta da Ferreira: " + conta.getId());
		conta.setSaldo(500.0);
		
		// O merge pega a conta Detached e transforma e Managed novamente
		em2.getTransaction().begin();
		em2.merge(conta);
		em2.getTransaction().commit();
	}
}