package com.decryptor.repository;

import com.decryptor.domain.GTINEntity;
import com.sun.xml.bind.v2.model.core.ID;
import liquibase.repackaged.org.apache.commons.lang3.NotImplementedException;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
@Repository
@Component
@AllArgsConstructor
@Transactional
public class HibernateGTINRepository implements HibernateRepository<GTINEntity> {

    private final SessionFactory sessionFactory;


    @Override
    public GTINEntity save(GTINEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public GTINEntity update(GTINEntity entity) {
        throw new NotImplementedException("NOT implemented.");
    }

    @Override
    public List<GTINEntity> getAll() {
        return sessionFactory.openSession().createNativeQuery("SELECT * FROM Decryptor.GTIN").getResultList();
    }

    @Override
    public Optional<GTINEntity> findById(Integer id) {
        var record = sessionFactory.openSession().get(GTINEntity.class, id);
        return Optional.ofNullable(record);
    }

    public Optional <GTINEntity> getByGTIN(String gtin){
        var interimResponse = sessionFactory.openSession().get(GTINEntity.class, gtin);
        var response = Optional.ofNullable(interimResponse);
        return response;
    }

    public String getIDByGTIN(String gtin){
        return sessionFactory.openSession().createQuery("SELECT i FROM GTIN where GTIN = " + gtin).toString();
    }

}
