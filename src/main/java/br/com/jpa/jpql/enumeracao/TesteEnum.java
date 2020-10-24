package br.com.jpa.jpql.enumeracao;

import javax.persistence.EntityManager;

import br.com.jpa.jpql.util.JpaUtil;

public class TesteEnum {

	public static void main(String[] args) {
		// Genérico
		EntityManager entityManager = JpaUtil.getEntityManager();

		try {
			/* Abrir transação */
			entityManager.getTransaction().begin();

			Pedido pedido = new Pedido();

			System.out.println("####### Populando banco > tabela pedido_enum #######");
			
			pedido.setNomeProduto("Notebook");
			pedido.setStatusPedido(StatusPedido.ANALISE);  // valor do enum será texto isso foi definido no enum
			pedido.setPerfilUsuario(PerfilUsuario.ADMINISTRADOR);  // no banco o valor é 0

//			pedido.setNomeProduto("Desktop");
//			pedido.setPerfilUsuario(PerfilUsuario.GERENTE); // no banco o valor é 1
//
//			pedido.setNomeProduto("Smart TV ");
//			pedido.setPerfilUsuario(PerfilUsuario.COMUM); // no banco o valor é 2

			System.out.println("Nome: " + pedido.getNomeProduto());
			System.out.println("---------------------------------------");

			System.out.println(
					"Perfil do Usuario: " + pedido.getPerfilUsuario() + " > No banco o tipo será Enum numeral ");
			System.out.println("---------------------------------------");

			/* persiste os dados */
			System.out.println("realizando persistencia de dados......");
			System.out.println("---------------------------");
			entityManager.persist(pedido);

			/* execulta transação */
			entityManager.getTransaction().commit();
			System.out.println("####### Dados persistidos com Sucesso! ###########");
			System.out.println("Nome: " + pedido.getNomeProduto());
			System.out.println(
					"Perfil do Usuario: " + pedido.getPerfilUsuario() + " > No banco o tipo será valor numerico de acordo com a ordem do Enum");
			System.out.println("####### Dados persistidos com Sucesso! ###########");

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