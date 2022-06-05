package com.decryptor.core.products;

import com.decryptor.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllProductsTest {

    @Mock
    ProductRepository productRepository;

    @Test
    void shouldGetAllProducts(){
        var service = new GetAllProducts(productRepository);
        var productEntityList = TestFactoryProduct.getAllProductsList();
        when(productRepository.findAll()).thenReturn(productEntityList);
        var actualResponse = service.findAll();
        var expectedResponse = TestFactoryProduct.getAllProductResponse();
        assertEquals(expectedResponse, actualResponse);
    }


}