package br.com.campoamesa.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserByServedCityRequestDTO {
    private List<String> cityIds;

    private String userId;

    public UserByServedCityRequestDTO() {}
}
