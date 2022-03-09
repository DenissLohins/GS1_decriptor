package com.decryptor.dto;


import lombok.Data;

import java.util.ArrayList;
@Data
public class GetHistoryResponse {
    ArrayList<String> response = new ArrayList<>();

    public GetHistoryResponse(ArrayList <String> responseFromDB) {
        this.response  = responseFromDB;
    }

    public void printInConsole(){
        for (int i = 0; i < response.size(); i++) {
            System.out.println(response.get(i));
        }
    }
}
