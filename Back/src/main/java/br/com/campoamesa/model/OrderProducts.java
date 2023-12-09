package br.com.campoamesa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class OrderProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "user_id")
    private String providerId;

    @JoinColumn(name = "user_id")
    private String userId;

    @ElementCollection
    private List<Product> productList;
}
