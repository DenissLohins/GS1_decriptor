package com.decryptor.core.requests;

import com.decryptor.domain.RequestEntity;
import com.decryptor.repository.RequestHistoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetByIDServiceTest {

    @Mock
    private RequestHistoryRepository repository;

    @InjectMocks
    private GetByIDService getByIDService;

    @Test
    void shouldGetById() {
        Integer id = 101;
        var returnResult = TestFactoryDecrypt.createGetByIdOptional(id);
        when(repository.findById(id)).thenReturn(returnResult);

        var result = getByIDService.getByID(id);
        var expectedResult = TestFactoryDecrypt.createGetByIdresponse(101);
        assertEquals(expectedResult, result);

    }

    @Test
    void shouldNotGetAnything(){
        Integer id = 101;
        Optional <RequestEntity> returnResult = Optional.empty();
        when(repository.findById(id)).thenReturn(returnResult);
        var result = getByIDService.getByID(id);
        assertNull(result.getResponseEntity());
    }


}