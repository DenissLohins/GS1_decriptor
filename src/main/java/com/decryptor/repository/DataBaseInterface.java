package com.decryptor.repository;

import com.decryptor.dto.GetHistoryResponse;

public interface DataBaseInterface {

    public void add(String query);
    public GetHistoryResponse getHistory();

}
