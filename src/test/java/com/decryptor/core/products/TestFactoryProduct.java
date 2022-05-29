package com.decryptor.core.products;

import com.decryptor.domain.ProductEntity;
import com.decryptor.dto.AddProductRequest;
import com.decryptor.dto.AddProductResponse;
import com.decryptor.dto.GetAllProductResponse;
import com.decryptor.dto.GetProductByIDResponse;

import java.util.List;
import java.util.Optional;

public class TestFactoryProduct {

    static AddProductRequest createAddProductRequest(){
        var gtin = "04751022900835";
        var name = "Dexmedetomidine 2 ml Pharmidea Latvia";
        var request = new AddProductRequest(gtin, name);
        return request;
    }
    static AddProductResponse createAddProductResponse(){
        var gtin = "04751022900835";
        var name = "Dexmedetomidine 2 ml Pharmidea Latvia";
        var response = new AddProductResponse(gtin, name);
        return response;
    }

    static ProductEntity createProductEntity(){
        var gtin = "04751022900835";
        var name = "Dexmedetomidine 2 ml Pharmidea Latvia";
        var entity = new ProductEntity(gtin, name);
        return entity;
    }

    static List<ProductEntity> getAllProductsList(){
        var gtin = "04751022900835";
        var name = "Dexmedetomidine 2 ml Pharmidea Latvia";
        var entity = new ProductEntity(gtin, name);
        var result = List.of(entity);
        return result;
    }
    static GetAllProductResponse getAllProductResponse(){
        var gtin = "04751022900835";
        var name = "Dexmedetomidine 2 ml Pharmidea Latvia";
        var entity = new ProductEntity(gtin, name);
        var result = List.of(entity);
        var response = new GetAllProductResponse(result);
        return response;
    }

    static Optional<ProductEntity> createOptionalWithProductEntity(){
        var gtin = "04751022900835";
        var name = "Dexmedetomidine 2 ml Pharmidea Latvia";
        var entity = new ProductEntity(gtin, name);
        var response = Optional.of(entity);
        return response;
    }
    static GetProductByIDResponse getProductByIDResponse(){
        var gtin = "04751022900835";
        var name = "Dexmedetomidine 2 ml Pharmidea Latvia";
        var response = new GetProductByIDResponse(gtin, name);
        return response;
    }
}
