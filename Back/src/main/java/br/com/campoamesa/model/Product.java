package br.com.campoamesa.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    private String description;

    @JoinColumn(name = "category_id")
    private Integer category;

    @JoinColumn(name = "user_id")
    private String providerId;

    private float value;

    private BigDecimal quantity;

    private String measureUnit;

    @ElementCollection
    private List<Integer> citiesIds;

    private Integer viewCounter = 0;

    private Boolean available = false;

    private float score = 0;

    private String productImageUrl;
}
