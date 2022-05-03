package com.decryptor.controller;

import com.decryptor.core.requests.DecryptService;
import com.decryptor.core.requests.GetByIDService;
import com.decryptor.core.requests.GetHistoryService;
import com.decryptor.dto.DecryptRequest;
import com.decryptor.dto.DecryptResponse;
import com.decryptor.dto.GetByIDResponse;
import com.decryptor.dto.GetHistoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class DecryptController  {
    private final DecryptService decryptService;
    private final GetByIDService getByIDService;
    private final GetHistoryService getHistoryService;


    @GetMapping("/decrypt")
    public GetHistoryResponse getHistory(){ return getHistoryService.findAll();}

    @GetMapping("/decrypt/{id}")
    public GetByIDResponse getByID(@PathVariable("id") Integer id) { return getByIDService.getByID(id);}

    @PostMapping("/decrypt")
    public DecryptResponse decrypt(@RequestBody DecryptRequest decryptRequest) {
        return decryptService.execute(decryptRequest);}
}
