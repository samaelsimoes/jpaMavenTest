package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		//para inserir dados preciso colocar o begin entre o begin e commit coloco os dados para persistir
		//Obs: quando n�o for busca por exemplo um cadastro ou deletar alguma informa��o precisamos fazer a transa��o 
		/*
			em.getTransaction().begin();		
			em.persist(p1);
			em.getTransaction().commit();
		*/
		
		// Buscando informa��es pelo ID
		//Pessoa p = em.find(Pessoa.class, 2);
		
		//Apagar uma informa��o do banco
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Deu certo");
		emf.close();
		em.close();
	}
}