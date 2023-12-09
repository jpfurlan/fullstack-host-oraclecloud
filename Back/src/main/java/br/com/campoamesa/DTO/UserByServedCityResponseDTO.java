package br.com.campoamesa.DTO;

import br.com.campoamesa.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserByServedCityResponseDTO {

    private String id;
    private String companyName;
    private String companyDescription;
    private String avatar;
    private List<Integer> categories;
    private List<String> serverdCities;
}
