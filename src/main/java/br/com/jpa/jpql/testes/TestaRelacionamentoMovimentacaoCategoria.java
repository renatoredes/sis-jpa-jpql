package br.com.jpa.jpql.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.jpql.modelo.Categoria;
import br.com.jpa.jpql.modelo.Conta;
import br.com.jpa.jpql.modelo.Movimentacao;
import br.com.jpa.jpql.modelo.TipoMovimentacao;

/**
 * 
 * @author Renato
 *
 */

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {

		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocio");

		Conta conta = new Conta();
		conta.setId(1L);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem E.U.A");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(300.0));
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem Canadá");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(400.0));
		movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao2.setConta(conta);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);

		em.getTransaction().commit();
		em.close();

	}
}
