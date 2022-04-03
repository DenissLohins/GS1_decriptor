package com.decryptor.repository;

import com.decryptor.domain.RequestEntity;
import com.decryptor.dto.RequestDTO;

import java.util.List;
import java.util.Optional;

public interface HibernateRepository {

    RequestEntity add (RequestEntity decryptRequest);

    List<RequestDTO> getHistory ();

    Optional<RequestEntity> findById (Integer id);
}
