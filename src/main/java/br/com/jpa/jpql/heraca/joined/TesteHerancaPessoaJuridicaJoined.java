package br.com.jpa.jpql.heraca.joined;

import javax.persistence.EntityManager;

import br.com.jpa.jpql.util.JpaUtil;

/**
 * 
 * @author Renato
 * Classe de teste responsável por persistir dados de Pessoa Fisica utilizando conceito de herança SigleTable
 */
public class TesteHerancaPessoaJuridicaJoined {

	public static void main(String[] args) {

		// Genérico
		EntityManager entityManager = JpaUtil.getEntityManager();

		try {
			/* Abrir transação */
			entityManager.getTransaction().begin();

			
			PessoaJuridicaJoined pessoaJuridicaJoined = new PessoaJuridicaJoined();
			pessoaJuridicaJoined.setNome("Renato_Redes_Software.sa");
			pessoaJuridicaJoined.setCNPJ("00.000.000/0001-00");
			
			System.out.println("realizando insert "+ " - " 
			+ pessoaJuridicaJoined.getNome() + " - "  
			+ pessoaJuridicaJoined.getCNPJ());
			
			/* persiste os dados */
			entityManager.persist(pessoaJuridicaJoined);
			/* execulta transação */
			entityManager.getTransaction().commit();
			System.out.println("Dados Pessoa Juridica persistido com Sucesso!");

		} catch (Exception e) {
			// se estiver conexão aberto, caso capturar uma Exception, fazer rollback
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
