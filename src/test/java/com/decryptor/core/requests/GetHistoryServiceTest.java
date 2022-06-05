package com.decryptor.core.requests;

import com.decryptor.domain.RequestEntity;
import com.decryptor.dto.GetHistoryResponse;
import com.decryptor.repository.RequestHistoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class GetHistoryServiceTest {


    @Mock
    private RequestHistoryRepository database;

    @InjectMocks
    private GetHistoryService getHistoryService;

    @Test
    void shouldFindAll() {
        var returnResult = entities();
        when(database.findAll()).thenReturn(returnResult);

        var result = getHistoryService.findAll();

        var expectedResult = response();

        assertEquals(expectedResult, result);
    }


    private List<RequestEntity> entities() {
        var returnEntity = new RequestEntity();
        returnEntity.setId(1);
        returnEntity.setRequest("]20115012727915088211312628744741060042117231231");
        returnEntity.setTime("19:37:44:86042");
        returnEntity.setDate("01.05.2022.");
        returnEntity.setProductID("15012727915088");
        return List.of(returnEntity);
    }

    private GetHistoryResponse response() {
        var dto = new RequestEntity();
        dto.setId(1);
        dto.setRequest("]20115012727915088211312628744741060042117231231");
        dto.setTime("19:37:44:86042");
        dto.setDate("01.05.2022.");
        dto.setProductID("15012727915088");
        return new GetHistoryResponse(List.of(dto));
    }
}