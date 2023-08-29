package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.dto.CityDTO;
import co.edu.uco.carpooling.dto.PointOfInterestDTO;
import co.edu.uco.carpooling.service.usecase.city.ListCityUseCase;
import co.edu.uco.carpooling.service.usecase.pointofinterest.ListPointOfInterestUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/carpooling/pointofinterest")
public class PointOfInterestController {

    @Autowired
    private ListPointOfInterestUseCase listPointOfInterestUseCase;

    @GetMapping()
    public List<PointOfInterestDTO> getPointOfInterest(){
        return listPointOfInterestUseCase.execute(Optional.of(PointOfInterestDTO.create()));
    }
}
