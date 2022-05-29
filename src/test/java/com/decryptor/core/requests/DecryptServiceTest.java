package com.decryptor.core.requests;

import com.decryptor.domain.RequestEntity;
import com.decryptor.dto.DecryptRequest;
import com.decryptor.repository.GetCurrentDateAndTime;
import com.decryptor.repository.PrefixDatabase;
import com.decryptor.repository.ProductRepository;
import com.decryptor.repository.RequestHistoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.decryptor.core.requests.TestFactoryDecrypt.createRequest;
import static com.decryptor.core.requests.TestFactoryDecrypt.createResponse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DecryptServiceTest {

    @Mock
    private RequestHistoryRepository repository;

    @Mock
    ProductRepository productRepository;




    @Test
    void shouldSucessfulDecrypt() {
        GetCurrentDateAndTime getCurrentDateAndTime = new GetCurrentDateAndTime();
        PrefixDatabase prefixDatabase = new PrefixDatabase();
        DecryptService decryptService = new DecryptService(prefixDatabase, repository, productRepository, getCurrentDateAndTime);
        var request = createRequest();
        var result = decryptService.execute(request);
        verify(repository, times(2)).save(any(RequestEntity.class));
        var expectedResult = createResponse();
        assertEquals(expectedResult, result);
    }

    @Test
    void shouldNotDecryptBytSaveOnce(){
        GetCurrentDateAndTime getCurrentDateAndTime = new GetCurrentDateAndTime();
        PrefixDatabase prefixDatabase = new PrefixDatabase();
        DecryptService decryptService = new DecryptService(prefixDatabase, repository, productRepository, getCurrentDateAndTime);
        var request = new DecryptRequest();
        request.setRequestString("1235");
        var result = decryptService.execute(request);
        verify(repository, times(1)).save(any(RequestEntity.class));
        }



}