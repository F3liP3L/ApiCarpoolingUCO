package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.domain.CityDomain;
import co.edu.uco.carpooling.service.usecase.city.ListCityUseCase;
import co.edu.uco.crosscutting.util.UtilText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/carpooling")
public class TestController {

    @Autowired
    private ListCityUseCase cityUseCase;

    @GetMapping("/{message}")
    public String sayHello(@PathVariable String message) {
        return UtilText.getUtilText().getDefault(message, "Buenas ❤️");
    }

    @GetMapping()
    public RouteDTO getRoute(){
        return RouteDTO.create();
    }

    @GetMapping("/citys")
    public List<CityDomain> cityDomainList(){
        return cityUseCase.execute();
    }



}


