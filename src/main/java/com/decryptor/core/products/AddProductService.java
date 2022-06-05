package com.decryptor.core.products;

import com.decryptor.domain.ProductEntity;
import com.decryptor.dto.AddProductRequest;
import com.decryptor.dto.AddProductResponse;
import com.decryptor.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@AllArgsConstructor
@Service
public class AddProductService {

    private ProductRepository gtinNames;


    public AddProductResponse add(AddProductRequest request){
        var entity = convertToEntity(request);
        gtinNames.save(entity);
        log.debug("Successfully saved: {}", entity);
        var response = convertToResponse(entity);
        return response;
        
    }


    private ProductEntity convertToEntity(AddProductRequest addProductRequest){
        var result = new ProductEntity();
        result.setGtin(addProductRequest.getGtin());
        result.setName(addProductRequest.getName());
        return result;
    }


    private AddProductResponse convertToResponse (ProductEntity entity){
        var result = new AddProductResponse();
        result.setGtin(entity.getGtin());
        result.setName(entity.getName());
        return result;
    }

}
