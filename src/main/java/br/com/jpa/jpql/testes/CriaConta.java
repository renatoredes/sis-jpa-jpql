package br.com.jpa.jpql.testes;

import javax.persistence.EntityManager;

import br.com.jpa.jpql.modelo.Conta;
import br.com.jpa.jpql.util.JpaUtil;

/**
 * 
 * @author Renato
 * 
 */
public class CriaConta {
	public static void main(String[] args) throws Exception {
		// Gen�rico
		EntityManager entityManager = JpaUtil.getEntityManager();

		try {
			/* Abrir transa��o */
			entityManager.getTransaction().begin();

			Conta conta = new Conta();
			conta.setTitular("Redes");
			conta.setNumero(1234);
			conta.setAgencia(1235);
			/* persiste os dados */
			entityManager.persist(conta);
			/* execulta transa��o */
			entityManager.getTransaction().commit();
			System.out.println("Dados inserido com Sucesso!");

		} catch (Exception e) {
			// se estiver conex�o aberto, caso capturar uma Exception, fazer rollback
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();

			}
		}
	}
}
