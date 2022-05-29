package com.decryptor.core.requests;

import com.decryptor.dto.GetByIDResponse;
import com.decryptor.repository.RequestHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetByIDService {
    @Autowired
    private final RequestHistoryRepository database;

    public GetByIDResponse getByID(Integer id) {
        var response = database.findById(id);
        if (response.isPresent()) {
            return new GetByIDResponse(response.get());
        } else {
            new IllegalArgumentException("Request with id " + id + " is not found.");
            return new GetByIDResponse();
        }
    }


}
