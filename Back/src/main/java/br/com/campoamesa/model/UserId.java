package br.com.campoamesa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.util.List;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class UserId {
    @Id
    @NotNull
    private String id;

    @NotNull
    private String email;

    @NotNull
    private Boolean isDone;

    @NotNull
    private Boolean isProvider;

    private String name;

    private String cpf;

    private String address;

    private String addressNumber;

    private String complement;

    private String cep;

    private String phone;

    private String city;

    private String state;

    private String servedState;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> servedCities;

    private float score = 0;

    private String companyName;

    private String companyDescription;

    private List<Integer> categories;

    private String avatar;

}