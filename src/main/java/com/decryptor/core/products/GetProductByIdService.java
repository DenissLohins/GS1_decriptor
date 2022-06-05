package com.decryptor.core.products;

import com.decryptor.domain.ProductEntity;
import com.decryptor.dto.GetProductByIDResponse;
import com.decryptor.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class GetProductByIdService {

    private final ProductRepository database;

    public GetProductByIDResponse getProductById(String id){
        var optionalFromDB = database.findById(id);
        if (optionalFromDB.isPresent()){
            log.debug("Object found");
            var response = convertToResponse(optionalFromDB);
            return response;
        }else {
            log.debug("Object not found");
            new IllegalArgumentException();
            return new GetProductByIDResponse();
        }
    }

    private GetProductByIDResponse convertToResponse(Optional<ProductEntity> optionalEntity){
        var response = new GetProductByIDResponse();
        response.setGtin(optionalEntity.get().getGtin());
        response.setName(optionalEntity.get().getName());
        return response;
    }
}
