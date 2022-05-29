package com.decryptor.core.products;

import com.decryptor.dto.GetAllProductResponse;
import com.decryptor.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class GetAllProducts {

    @Autowired
    private final ProductRepository database;


    public GetAllProductResponse findAll() {
        var productEntities = database.findAll();
        var listLength  = productEntities.size();
        log.debug("Successful get {} records from database all product list", listLength);
        return new GetAllProductResponse(productEntities);
    }


}
