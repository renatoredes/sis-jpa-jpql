# JPA - JPQL
Exemplo Persistência  de dados utilizando JPA e consulta com JPQL

```
##### CRIAÇÃO DO BANCO: #####

CREATE DATABASE bdjpa;

##### BANCO: #####
Consultas Tabelas utilizando SQL

select * from conta;
select * from movimentacao;
select * from categoria;
select * from cliente;
select * from movimentacao_categoria;

```
### Relacionamento

```
@ManyToOne
@ManyToMany
 
```
### Exemplo utilizando Enum
```
public enum TipoMovimentacao {
	ENTRADA, SAIDA;
}
```
### Exemplos de Persistência de dados

```
EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);

		em.getTransaction().commit();
		em.close();
  
  ```
  
  ### Exemplo Consultando dados utilizando JPQL
    
  ```
  	String sql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
    
  ```
 ### Exemplo Consultando dados utilizando JPQL e INNER JOIN
  
  ```
String sql = "select m from Movimentacao m join m.categorias c where c = :pCategoria"; 
 
  ```
  
  
  
  
  
  
  

