package com.decryptor.config.controller;

import com.decryptor.core.products.AddProductService;
import com.decryptor.core.products.GetAllProducts;
import com.decryptor.core.products.GetProductByIdService;
import com.decryptor.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductController {

    private final AddProductService addProductService;
    private final GetAllProducts getAllProducts;
    private final GetProductByIdService getProductByIdService;


    @GetMapping("/gtin")
    public GetAllProductResponse getAllGtin(){
        return getAllProducts.findAll();
    }

    @PostMapping("/gtin")
    public AddProductResponse add(@RequestBody AddProductRequest request){
        return addProductService.add(request);
    }

    @GetMapping("/gtin/{id}")
    public GetProductByIDResponse getProductByID (@PathVariable String id){
        return getProductByIdService.getProductById(id);
    }

}
