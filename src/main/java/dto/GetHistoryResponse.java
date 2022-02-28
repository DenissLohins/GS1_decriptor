package dto;

import repository.RepositoryObject;

import java.util.ArrayList;

public class GetHistoryResponse {
    private ArrayList<String> response = new ArrayList<>();


    public void add(RepositoryObject object){
        String interimresult = object.toString();
        response.add(interimresult);
    }

    public void printInConsole(){
        for (int i = 0; i < response.size(); i++) {
            System.out.println(response.get(i));
        }
    }
}
