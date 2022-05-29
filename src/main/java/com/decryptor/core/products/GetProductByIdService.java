package com.decryptor.core.products;

import com.decryptor.dto.GetProductByIDRequest;
import com.decryptor.dto.GetProductByIDResponse;
import com.decryptor.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class GetProductByIdService {

    private final ProductRepository database;

    public GetProductByIDResponse getProductById(String id){
        var result = database.findById(id);
        if (result.isPresent()){
            log.debug("Object found");
            var response = new GetProductByIDResponse(result.get().getGtin(), result.get().getName());
            return response;
        }else {
            log.debug("Object not found");
            new IllegalArgumentException();
            return new GetProductByIDResponse();
        }
    }
}
