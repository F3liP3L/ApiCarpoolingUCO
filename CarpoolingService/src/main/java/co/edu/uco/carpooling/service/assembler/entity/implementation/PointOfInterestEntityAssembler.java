package co.edu.uco.carpooling.service.assembler.entity.implementation;

import co.edu.uco.carpooling.dto.PointOfInterestDTO;
import co.edu.uco.carpooling.entity.PointOfInterestEntity;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.domain.PointOfInterestDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PointOfInterestEntityAssembler implements EntityAssembler<PointOfInterestEntity, PointOfInterestDomain, PointOfInterestDTO> {
    private ModelMapper modelMapper;

    public PointOfInterestEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public PointOfInterestDomain assembleDomain(PointOfInterestEntity entity) {
        return modelMapper.map(entity, PointOfInterestDomain.class);
    }

    @Override
    public PointOfInterestEntity assembleEntity(PointOfInterestDomain domain) {
        return modelMapper.map(domain, PointOfInterestEntity.class);
    }

    @Override
    public PointOfInterestDTO assembleDTO(PointOfInterestEntity entity) {
        return null;
    }

}
