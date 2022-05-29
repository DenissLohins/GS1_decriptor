package com.decryptor.core.requests;

import com.decryptor.dto.DecryptRequest;

public class TestDTOfactory {

    public static DecryptRequest createRequest() {
        var request = new DecryptRequest();
        request.setRequestString("]20104751022900835211312628744741060042117231231");
        return request;
    }
}
