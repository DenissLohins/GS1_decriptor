package com.decryptor.core.products;

import com.decryptor.dto.AddProductRequest;
import com.decryptor.dto.AddProductResponse;
import com.decryptor.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class AddProductService {

    @Autowired
    private ProductRepository gtinNames;

    private ProductConverter converter;

    public AddProductResponse add(AddProductRequest request){
        var entity = converter.convertFromRequest(request);
        gtinNames.save(entity);
        log.debug("Successfully saved: {}", entity);
        var response = converter.convertToResponse(entity);
        return response;
    }

}
