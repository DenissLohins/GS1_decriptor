package com.decryptor.core.requests;

import com.decryptor.domain.RequestEntity;
import com.decryptor.dto.DecryptResponse;
import com.decryptor.repository.RequestHistoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.decryptor.core.requests.TestDTOfactory.createRequest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DecryptServiceTest {

    @Mock
    private RequestHistoryRepository repository;

    @Mock
    private DecryptService decryptService;

    @Test
    void shouldSucessfulDecrypt() {
        var request = createRequest();
        when(repository.save(entity(null))).thenReturn(entity(1001));
        var result = decryptService.execute(request);
        verify(repository).save(any());
        var expected = new DecryptResponse();
        expected.setID(1001);
        expected.setRequest("]20104751022900835211312628744741060042117231231");
assertEquals(expected, result);

    }

private RequestEntity entity(Integer id){
var entity = new RequestEntity();
entity.setId(id);
entity.setRequest("]20104751022900835211312628744741060042117231231");
return entity;
}
}