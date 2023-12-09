package br.com.campoamesa.controller;

import br.com.campoamesa.DTO.UserByServedCityRequestDTO;
import br.com.campoamesa.DTO.UserByServedCityResponseDTO;
import br.com.campoamesa.model.Category;
import br.com.campoamesa.model.ExplorerFilter;
import br.com.campoamesa.model.UserId;
import br.com.campoamesa.repository.ExplorerFilterRepository;
import br.com.campoamesa.service.ExplorerFilterService;
import br.com.campoamesa.service.UserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filter")
public class ExplorerFilterController {

    @Autowired
    private ExplorerFilterRepository explorerFilterRepository;

    @Autowired
    private ExplorerFilterService explorerFilterService;


    @CrossOrigin
    @PostMapping("/findByServedCities")
    public ResponseEntity<List<UserByServedCityResponseDTO>> findSummaryByServedCities(
            @RequestBody UserByServedCityRequestDTO cityRequest) {

        // Chamada de serviço que lida com ambas as situações
        List<UserId> userIds = explorerFilterService.findUserIdsByServedCitiesExcludingUser(
                cityRequest.getCityIds(),
                cityRequest.getUserId());

        List<UserByServedCityResponseDTO> dtos = userIds.stream()
                .map(userId -> new UserByServedCityResponseDTO(
                        userId.getId(),
                        userId.getCompanyName(),
                        userId.getCompanyDescription(),
                        userId.getAvatar(),
                        userId.getCategories(),
                        userId.getServedCities()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }
}
