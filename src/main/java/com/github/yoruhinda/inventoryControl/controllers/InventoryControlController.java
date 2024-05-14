package com.github.yoruhinda.inventoryControl.controllers;

import com.github.yoruhinda.inventoryControl.dto.ProductDto;
import com.github.yoruhinda.inventoryControl.models.Product;
import com.github.yoruhinda.inventoryControl.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryControlController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> update(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Product> delete(){
        return null;
    }
}
