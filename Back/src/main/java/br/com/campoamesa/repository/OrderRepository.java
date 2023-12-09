package br.com.campoamesa.repository;

import br.com.campoamesa.model.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderProducts, Integer> {
}
