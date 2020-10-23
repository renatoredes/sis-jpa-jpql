package br.com.jpa.jpql.testes;

import javax.persistence.EntityManager;

import br.com.jpa.jpql.heraca.sigleTable.PessoaJuridicaSigleTable;
import br.com.jpa.jpql.util.JpaUtil;

/**
 * 
 * @author Renato
 * Classe de teste responsável por persistir dados de Pessoa Fisica utilizando conceito de herança SigleTable
 */
public class TesteHerancaPessoaJuridicaSigleTable {

	public static void main(String[] args) {

		// Genérico
		EntityManager entityManager = JpaUtil.getEntityManager();

		try {
			/* Abrir transação */
			entityManager.getTransaction().begin();

			
			PessoaJuridicaSigleTable pessoaJuridicaSigleTable = new PessoaJuridicaSigleTable();
			
			System.out.println("Inserindo dados de Pessoa Fisica");
			
			pessoaJuridicaSigleTable.setNome("Renato_Redes_Software.sa");
			pessoaJuridicaSigleTable.setCNPJ("00.000.000/0001-00");
			
			System.out.println("realizando insert "+ " - " 
			+ pessoaJuridicaSigleTable.getNome() + " - "  
			+ pessoaJuridicaSigleTable.getCNPJ());
			
			/* persiste os dados */
			entityManager.persist(pessoaJuridicaSigleTable);
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
