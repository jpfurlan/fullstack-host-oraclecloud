package br.com.campoamesa.service;

import br.com.campoamesa.model.OrderProducts;
import br.com.campoamesa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderProducts save(OrderProducts orderProducts) {
        return orderRepository.save(orderProducts);
    }

}
