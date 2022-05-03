package com.decryptor.core.gtinList;

import com.decryptor.domain.GTINEntity;
import com.decryptor.dto.AddGtinRequest;
import com.decryptor.dto.AddGtinResponse;
import com.decryptor.repository.HibernateGTINRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class AddGTINService {

    @Autowired
    private HibernateGTINRepository gtinNames;

    public AddGtinResponse add(AddGtinRequest request){
        var response = new AddGtinResponse();

        var validationResult =

        return response;
    }

}
