package co.edu.uco.carpooling.service.usecase.city.implementation;

import co.edu.uco.carpooling.infrastructure.adapter.repository.CityRepository;
import co.edu.uco.carpooling.service.assembler.entity.implementation.CityEntityAssembler;
import co.edu.uco.carpooling.service.domain.CityDomain;
import co.edu.uco.carpooling.service.usecase.city.ListCityUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListCityUseCaseImpl implements ListCityUseCase {

    @Autowired
    private CityEntityAssembler cityEntityAssembler;
    private final CityRepository cityRepository;

    public ListCityUseCaseImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDomain> execute() {
        return cityRepository.findAll().stream().map(cityEntity -> cityEntityAssembler.assembleDomain(cityEntity)).collect(Collectors.toList());
    }

}
