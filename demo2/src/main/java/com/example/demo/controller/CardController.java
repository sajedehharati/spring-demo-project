package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.CreditCard;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@RestController
@RequestMapping
@Slf4j
@AllArgsConstructor
public class CardController {

    @Operation(description = "give me the balance of card")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CreditCard.class)))
    @GetMapping(value = "/get-card/{creditCardNumber}", headers = {"accept=application/json"})
    public ResponseEntity<CreditCard> getCreditCard(
        @Parameter(description = "The credit card number")
        @PathVariable(value = "creditCardNumber")
            String creditCardNumber
    ) {
        CreditCard creditCard = new CreditCard(creditCardNumber, 1000000.0f);
        return new ResponseEntity<>(creditCard, HttpStatus.OK);
    }
}
