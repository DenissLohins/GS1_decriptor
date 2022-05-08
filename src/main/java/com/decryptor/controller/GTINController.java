package com.decryptor.controller;

import com.decryptor.core.gtinList.AddProductService;
import com.decryptor.core.gtinList.GetAllProducts;
import com.decryptor.core.gtinList.GetProductByIdService;
import com.decryptor.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class GTINController {

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

    @GetMapping("/gtin/id")
    public GetProductByIDResponse getProductByID (@RequestBody GetProductByIDRequest request){
        return getProductByIdService.getProductById(request);
    }

}
