package br.com.campoamesa.controller;

import br.com.campoamesa.model.Product;
import br.com.campoamesa.service.ProductService;
import br.com.campoamesa.service.UserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserIdService userIdService;
    @CrossOrigin
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/findByUserId/{providerId}")
    public List<Product> findByProviderId(@PathVariable String providerId) {
        return productService.findByProviderId(providerId);
    }

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
            Product savedProduct = productService.save(product);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }


    @CrossOrigin
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProduct = productService.findById(id);

        if (existingProduct.isPresent()) {
            updatedProduct.setId(id);
            productService.save(updatedProduct);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        Optional<Product> existingProduct = productService.findById(id);

        if (existingProduct.isPresent()) {
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping("/image")
    public ResponseEntity<Product> saveProductImage(@RequestBody Product product) {
        Product existingProduct = productService.findById(product.getId()).orElse(null);
        if (existingProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        productService.setProductImageUrl(product.getId(), product.getProductImageUrl());
        Product productAfter = productService.findById(product.getId()).orElse(null);

        return new ResponseEntity<>(productAfter, HttpStatus.CREATED);
    }
}
