package com.decryptor.repository;

import com.decryptor.domain.ProductEntity;
import liquibase.repackaged.org.apache.commons.lang3.NotImplementedException;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
@Component
@AllArgsConstructor
@Transactional
public class HibernateGTINRepository implements HibernateRepository<ProductEntity> {

    private final SessionFactory sessionFactory;


    @Override
    public ProductEntity save(ProductEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public ProductEntity update(ProductEntity entity) {
        throw new NotImplementedException("NOT implemented.");
    }

    @Override
    public List<ProductEntity> getAll() {
        return sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM gtin").getResultList();
    }


    public Optional<ProductEntity> findById(String id) {
        var record = sessionFactory.getCurrentSession().get(ProductEntity.class, id);
        return Optional.ofNullable(record);
    }

    public Optional <ProductEntity> getByGTIN(String gtin){
        var interimResponse = sessionFactory.getCurrentSession().get(ProductEntity.class, gtin);
        var response = Optional.ofNullable(interimResponse);
        return response;
    }


}
