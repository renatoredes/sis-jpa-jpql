package br.com.jpa.jpql.testes;

import javax.persistence.EntityManager;

import br.com.jpa.jpql.heraca.sigleTable.PessoaJuridicaSigleTable;
import br.com.jpa.jpql.util.JpaUtil;

/**
 * 
 * @author Renato
 * Classe de teste respons�vel por persistir dados de Pessoa Fisica utilizando conceito de heran�a SigleTable
 */
public class TesteHerancaPessoaJuridicaSigleTable {

	public static void main(String[] args) {

		// Gen�rico
		EntityManager entityManager = JpaUtil.getEntityManager();

		try {
			/* Abrir transa��o */
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
			/* execulta transa��o */
			entityManager.getTransaction().commit();
			System.out.println("Dados Pessoa Juridica persistido com Sucesso!");

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
