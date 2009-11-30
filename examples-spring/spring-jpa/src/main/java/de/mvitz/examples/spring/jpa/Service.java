package de.mvitz.examples.spring.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("service")
@Transactional
public class Service {

    @PersistenceContext
    private EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public MyEntity createEntity(String value) {
        MyEntity e = new MyEntity(value);
        em.persist(e);
        return e;
    }

    public MyEntity getEntityForId(long id) {
        MyEntity e = em.find(MyEntity.class, id);
        return e;
    }

}
