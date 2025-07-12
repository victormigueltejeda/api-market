package com.market.api_market.web.controller;


import com.market.api_market.domain.Purchase;
import com.market.api_market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;


    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){
      return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    };
    @GetMapping("/{clienteId}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("clienteId") String clienteId) {
        return purchaseService.getByClient(clienteId)
                .map(purchase -> new ResponseEntity<>(purchase,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase),HttpStatus.CREATED);
    }


}
