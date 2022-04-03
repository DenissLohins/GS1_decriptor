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
public class HibernateRequestHistoryRepository implements HibernateRepository {

    private final SessionFactory sessionFactory;

    HibernateRequestHistoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public RequestEntity add(RequestEntity decryptRequest) {
        sessionFactory.getCurrentSession().save(decryptRequest);
        return decryptRequest;
    }

    @Override
    public List<RequestDTO> getHistory() {
        return sessionFactory.getCurrentSession().createQuery("SELECT r FROM request r").getResultList();
    }

    @Override
    public Optional<RequestEntity> findById(Integer id) {
        var record = sessionFactory.getCurrentSession().get(RequestEntity.class, id);
        return Optional.ofNullable(record);
    }
}
