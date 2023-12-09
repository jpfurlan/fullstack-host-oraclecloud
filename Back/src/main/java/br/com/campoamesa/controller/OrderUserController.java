package br.com.campoamesa.controller;

import br.com.campoamesa.model.OrderProducts;
import br.com.campoamesa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderUserController {

    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @PostMapping("/create-order")
    public ResponseEntity<OrderProducts> createProduct(@RequestBody OrderProducts product) {
        OrderProducts savedOrder = orderService.save(product);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
