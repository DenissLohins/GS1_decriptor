package com.decryptor.core.products;

import com.decryptor.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetProductByIdServiceTest {

    @Mock
    ProductRepository productRepository;

    @Test
    void shouldGetAProduct(){
        var id = "04751022900835";
        var service = new GetProductByIdService(productRepository);
        var productEntity = TestFactoryProduct.createProductEntity();
        var optionalFromDB = TestFactoryProduct.createOptionalWithProductEntity();
        when(productRepository.findById(id)).thenReturn(optionalFromDB);
        var actualResponse = service.getProductById(id);
        var expectedResponse = TestFactoryProduct.getProductByIDResponse();
        assertEquals(expectedResponse, actualResponse);
    }


}