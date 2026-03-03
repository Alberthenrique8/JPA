package br.com.albert.domain.dao;
import br.com.albert.domain.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MarcaDAO implements IMarcaDAO {

    @Override
    public Marca cadastrar(Marca marca) {
        EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return marca;

    }
}
