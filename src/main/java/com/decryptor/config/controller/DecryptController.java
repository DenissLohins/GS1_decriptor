package com.decryptor.config.controller;

import com.decryptor.core.requests.DecryptService;
import com.decryptor.core.requests.GetByIDService;
import com.decryptor.core.requests.GetHistoryService;
import com.decryptor.dto.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
public class DecryptController {
    private final DecryptService decryptService;
    private final GetByIDService getByIDService;
    private final GetHistoryService getHistoryService;


    @GetMapping("/decrypt")
    public GetHistoryResponse getHistory() {
        log.info("Received find all requests request");
        return getHistoryService.findAll();
    }

    @GetMapping("/decrypt/{id}")
    public GetByIDResponse getByID(@PathVariable("id") Integer id) {
        return getByIDService.getByID(id);
    }

    @PostMapping("/decrypt")
    public DecryptResponse decrypt(@RequestBody @Valid DecryptRequest decryptRequest, UriComponentsBuilder uriComponentsBuilder) {
        log.info("Received decrypt request: {}", decryptRequest);
        var entity = decryptService.execute(decryptRequest);
        var uri = uriComponentsBuilder
                .path("/decrypt/{id}")
                .buildAndExpand(entity.getID())
                .toUri();
        entity.setUri(uri);
        return entity;
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handle(IllegalArgumentException e) {
        return new ErrorResponseDto(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handle(MethodArgumentNotValidException e) {
        var errorMessages = e.getBindingResult().getFieldErrors().stream()
                .map(field -> String.format("Field validation failed. Field: %s, message: %s",
                        field.getField(), field.getDefaultMessage()))
                .toList();
        return new ErrorResponseDto(errorMessages.toString());
    }
}
