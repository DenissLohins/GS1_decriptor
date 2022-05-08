package com.decryptor.repository;

import com.decryptor.domain.RequestEntity;
import com.decryptor.dto.DecryptResponse;
import com.decryptor.dto.RequestDTO;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateRequestHistoryRepository implements HibernateRepository<RequestEntity> {

    private final SessionFactory sessionFactory;

    HibernateRequestHistoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public RequestEntity save(RequestEntity requestEntity) {
        sessionFactory.getCurrentSession().save(requestEntity);
        return requestEntity;
    }

    @Override
    public RequestEntity update(RequestEntity requestEntity) {
        sessionFactory.getCurrentSession().update(requestEntity);
        return requestEntity;
    }


    @Override
    public List<RequestEntity> getAll() {
        return sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM request_history", RequestEntity.class).getResultList();
    }


    public Optional<RequestEntity> findById(Integer id) {
        var record = sessionFactory.getCurrentSession().get(RequestEntity.class, id);
        return Optional.ofNullable(record);
    }
}
