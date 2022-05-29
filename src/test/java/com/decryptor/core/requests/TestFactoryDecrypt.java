package com.decryptor.core.requests;

import com.decryptor.domain.RequestEntity;
import com.decryptor.dto.DecryptRequest;
import com.decryptor.dto.DecryptResponse;
import com.decryptor.dto.GetByIDResponse;

import java.util.Optional;

public class TestFactoryDecrypt {

    static DecryptRequest createRequest() {
        var request = new DecryptRequest();
        request.setRequestString("]20104751022900835211312628744741060042117231231");
        return request;
    }

    static DecryptResponse createResponse() {
        var response = new DecryptResponse();
        response.setRequest("]20104751022900835211312628744741060042117231231");
        response.setDecryptedInformation("GTIN: 04751022900835; Serial number: 131262874474; Batch No.: 600421; Expiration date(YYMMDD): 231231; ");
        response.setID(null);
        response.setUri(null);
        return response;
    }
    static GetByIDResponse createGetByIdresponse(Integer id){
        var response = new GetByIDResponse();
        var responseEntity = new RequestEntity();
        responseEntity.setTime(null);
        responseEntity.setDate(null);
        responseEntity.setProductID("Test Product Id");
        responseEntity.setRequest("Test request");
        responseEntity.setId(id);
        response.setResponseEntity(responseEntity);
        return response;
    }

    static Optional<RequestEntity> createGetByIdOptional(Integer id){
        var responseEntity = new RequestEntity();
        responseEntity.setTime(null);
        responseEntity.setDate(null);
        responseEntity.setProductID("Test Product Id");
        responseEntity.setRequest("Test request");
        responseEntity.setId(id);
        var response = Optional.of(responseEntity);
        return response;

    }
}
