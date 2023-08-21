package co.edu.uco.carpooling.service.usecase.city;

import co.edu.uco.carpooling.service.domain.CityDomain;
import co.edu.uco.carpooling.service.usecase.UseCase;

import java.util.List;

public interface ListCityUseCase {
    List<CityDomain> execute();
}
