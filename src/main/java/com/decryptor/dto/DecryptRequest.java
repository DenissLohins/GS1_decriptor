package com.decryptor.dto;

import lombok.Data;

import java.util.Objects;
@Data
public class DecryptRequest {

    private final String requestString;

    public DecryptRequest(String requestString) {
        this.requestString = requestString;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DecryptRequest that = (DecryptRequest) o;
        return Objects.equals(requestString, that.requestString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestString);
    }

    public String getRequestString() {
        return requestString;
    }
}
