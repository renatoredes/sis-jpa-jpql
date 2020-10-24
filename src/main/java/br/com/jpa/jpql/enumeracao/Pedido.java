package br.com.jpa.jpql.enumeracao;

import javax.persistence.*;

/**
 * 
 * @author Renato Exemplo utiliza��o de tipos EnumType Exemplo: tipoUsuario
 * @Enumerated indica a JPA que indica a JPA como armazenar o valor do enum no
 *             banco de dados. Como n�o estou passando parametro na anota��o
 *             esse valor ser� salvo no banco de forma ordinal. ou seja:
 *             conforme estiver ordendado os atributos.
 * 
 * @Enumerated(EnumType.STRING) Com essa op��o a JPA salvar� o valor do atributo
 *                              ou seja: O Texto APROVADo, ANALISE
 * 
 */
@Entity
@Table(name = "Pedido_Enum")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nomeProduto;

	@Enumerated
	private PerfilUsuario perfilUsuario;

	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido;

	// -- get's e set's --//

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

}
