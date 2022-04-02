package com.decryptor.repository;

import com.decryptor.domain.RequestHistory;
import com.decryptor.dto.DecryptRequest;
import com.decryptor.dto.DecryptResponse;
import com.decryptor.dto.GetHistoryResponse;

import java.util.Optional;

public interface HibernateRepository {

    DecryptResponse add (String decryptRequest);

    GetHistoryResponse getHistory ();

    Optional<RequestHistory> findById (Integer id);
}
