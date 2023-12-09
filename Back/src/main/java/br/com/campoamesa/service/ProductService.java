package br.com.campoamesa.service;

import br.com.campoamesa.model.Product;
import br.com.campoamesa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByProviderId(String providerId) {
        return productRepository.findByProviderId(providerId);
    }

    public void setProductImageUrl(Integer id, String productImageUrl) {
        productRepository.setProductImageUrl(id, productImageUrl);
    }
}