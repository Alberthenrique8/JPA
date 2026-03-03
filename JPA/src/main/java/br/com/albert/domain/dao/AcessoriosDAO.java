package br.com.albert.domain.dao;
import br.com.albert.domain.Acessorios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AcessoriosDAO  implements IAcessariosDAO{

    @Override
    public Acessorios cadastrar(Acessorios acessorio) {
        EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return acessorio;

    }



}
