package com.decryptor.repository;

import com.decryptor.domain.RequestHistory;
import com.decryptor.dto.DecryptResponse;
import com.decryptor.dto.GetHistoryResponse;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class HibernateRequestHistoryRepository implements HibernateRepository{

    private final SessionFactory sessionFactory;

    HibernateRequestHistoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public DecryptResponse add(String decryptRequest) {
        sessionFactory.getCurrentSession().save(decryptRequest);
        return new DecryptResponse(decryptRequest);
    }

    @Override
    public GetHistoryResponse getHistory() {
//        return (GetHistoryResponse) sessionFactory.getCurrentSession().createCriteria(RequestHistory.class).list();
        return (GetHistoryResponse) sessionFactory.getCurrentSession().createQuery("SELECT * FROM Decryptor.RequestHistory").getResultList();
    }

    @Override
    public Optional<RequestHistory> findById(Integer id) {
        var record = sessionFactory.getCurrentSession().get(RequestHistory.class, id);
        return Optional.empty();
    }
}
