package br.com.albert.domain.dao;
import br.com.albert.domain.Carro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CarroDAO implements ICarroDAO {

    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return carro;

    }
}
