package br.com.campoamesa.repository;

import br.com.campoamesa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.providerId = ?1")
    List<Product> findByProviderId(String providerId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Product p SET p.productImageUrl = ?2 WHERE p.id = ?1")
    void setProductImageUrl(Integer id, String productImageUrl);
}
