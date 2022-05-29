package com.decryptor.repository;

import com.decryptor.domain.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestHistoryRepository extends JpaRepository<RequestEntity, Integer> {
}
