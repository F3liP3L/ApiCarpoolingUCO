package co.edu.uco.carpooling.service.assembler.entity.implementation;

import co.edu.uco.carpooling.dto.StatusDTO;
import co.edu.uco.carpooling.entity.StatusEntity;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.domain.StatusDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StatusEntityAssembler implements EntityAssembler<StatusEntity, StatusDomain, StatusDTO> {

    private final ModelMapper modelMapper;

    public StatusEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public StatusDomain assembleDomain(StatusEntity entity) {
        return modelMapper.map(entity, StatusDomain.class);
    }

    @Override
    public StatusEntity assembleEntity(StatusDomain domain) {
        return modelMapper.map(domain, StatusEntity.class);
    }

    @Override
    public StatusDTO assembleDTO(StatusEntity entity) {
        return modelMapper.map(entity, StatusDTO.class);
    }
}
