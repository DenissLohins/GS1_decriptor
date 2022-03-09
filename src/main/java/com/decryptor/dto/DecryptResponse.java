package com.decryptor.dto;

import java.util.Objects;

public class DecryptResponse {

    private final String response;

    public DecryptResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DecryptResponse that = (DecryptResponse) o;
        return Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response);
    }
}
