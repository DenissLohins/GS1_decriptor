package com.decryptor.core.gtinList;

import com.decryptor.dto.AddProductRequest;
import com.decryptor.dto.AddProductResponse;
import com.decryptor.repository.HibernateGTINRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class AddProductService {

    @Autowired
    private HibernateGTINRepository gtinNames;

    private GtinConverter converter;

    public AddProductResponse add(AddProductRequest request){
        var entity = converter.convertFromRequest(request);
        gtinNames.save(entity);
        log.debug("Successfully saved: {}", entity);
        var response = converter.convertToResponse(entity);
        return response;
    }

}
