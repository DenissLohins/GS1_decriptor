package com.decryptor.core.gtinList;

import com.decryptor.domain.ProductEntity;
import com.decryptor.dto.GetAllProductResponse;
import com.decryptor.repository.HibernateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class GetAllProducts {

    @Autowired
    private final HibernateRepository<ProductEntity> database;


    public GetAllProductResponse findAll() {
        var requests = database.getAll().stream()
                .toList();
        log.debug("Successful get from database all product list");
        return new GetAllProductResponse(requests);
    }


}
