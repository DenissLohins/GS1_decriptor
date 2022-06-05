package com.decryptor.core.products;

import com.decryptor.domain.ProductEntity;
import com.decryptor.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddProductServiceTest {

    @Mock
    ProductRepository productRepository;


    @Test
    void shouldAddProduct(){
        var service = new AddProductService(productRepository);
        var entity = TestFactoryProduct.createProductEntity();
        var request = TestFactoryProduct.createAddProductRequest();
        var actualResponse = service.add(request);
        System.out.println(entity);
        System.out.println(request);
        System.out.println(actualResponse);
        verify(productRepository, times(1)).save(any(ProductEntity.class));
        var expectedResponse = TestFactoryProduct.createAddProductResponse();
        assertEquals(expectedResponse, actualResponse);
    }

}