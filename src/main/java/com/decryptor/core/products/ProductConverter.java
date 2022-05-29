package com.decryptor.core.products;

import com.decryptor.domain.ProductEntity;
import com.decryptor.dto.AddProductRequest;
import com.decryptor.dto.AddProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductEntity convertFromRequest(AddProductRequest addProductRequest){
        var result = new ProductEntity();
        result.setGtin(addProductRequest.getGtin());
        result.setName(addProductRequest.getName());
        return result;
    }


    public AddProductResponse convertToResponse (ProductEntity entity){
        var result = new AddProductResponse();
        result.setGtin(entity.getGtin());
        result.setName(entity.getName());
        return result;
    }
}
