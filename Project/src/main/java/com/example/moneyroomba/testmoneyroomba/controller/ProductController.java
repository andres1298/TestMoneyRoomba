package com.example.moneyroomba.testmoneyroomba.controller;

import com.example.moneyroomba.testmoneyroomba.entities.Product;
import com.example.moneyroomba.testmoneyroomba.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable(value="id") int id){
        return productRepository.findById(id);
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") int id, @RequestBody Product incomingProduct){
        Optional<Product> currentProduct = productRepository.findById(id);

        currentProduct.get().setName(incomingProduct.getName());
        currentProduct.get().setDescription(incomingProduct.getDescription());
        currentProduct.get().setAmount(incomingProduct.getAmount());
        currentProduct.get().setPrice(incomingProduct.getPrice());

        Product updatedProduct = productRepository.save(currentProduct.get());
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") int id){
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count")
    public long countProducts(){
        return productRepository.count();
    }

    @GetMapping("ordered")
    public List<Product> getAllByName(){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name","description"));
    }
}
