package com.decryptor.core.gtinList;

import com.decryptor.dto.GetProductByIDRequest;
import com.decryptor.dto.GetProductByIDResponse;
import com.decryptor.repository.HibernateGTINRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class GetProductByIdService {

    private final HibernateGTINRepository database;

    public GetProductByIDResponse getProductById(GetProductByIDRequest request){
        var id = request.getGtin();
        var result = database.findById(id);
        log.debug("Result from DB obtained");
        if (result.isPresent()){
            log.debug("object found");
            var response = new GetProductByIDResponse(result.get().getGtin(), result.get().getName());
            return response;
        }else {
            log.debug("Object not found");
            new IllegalArgumentException("Product with id " + id + " is not found.");
            return new GetProductByIDResponse();
        }
    }
}
