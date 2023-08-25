package co.edu.uco.carpooling.service.assembler.entity.implementation;

import co.edu.uco.carpooling.dto.CityDTO;
import co.edu.uco.carpooling.entity.CityEntity;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.domain.CityDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class CityEntityAssembler implements EntityAssembler<CityEntity, CityDomain, CityDTO> {
    private final ModelMapper modelMapper;

    public CityEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public CityDomain assembleDomain(CityEntity entity) {
        return modelMapper.map(entity, CityDomain.class);
    }

    @Override
    public CityEntity assembleEntity(CityDomain domain) {
        return modelMapper.map(domain, CityEntity.class);
    }
    @Override
    public CityDTO assembleDTO(CityEntity entity) {
        return modelMapper.map(entity, CityDTO.class);
    }

}
