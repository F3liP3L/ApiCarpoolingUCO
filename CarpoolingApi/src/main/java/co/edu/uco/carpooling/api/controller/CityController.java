package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.dto.CityDTO;
import co.edu.uco.carpooling.service.usecase.city.ListCityUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/carpooling/city")
public class CityController {
    @Autowired
    private ListCityUseCase listCityUseCase;

    @GetMapping()
    public List<CityDTO> getAllCities() {
        return listCityUseCase.execute(Optional.of(CityDTO.create()));
    }
}
