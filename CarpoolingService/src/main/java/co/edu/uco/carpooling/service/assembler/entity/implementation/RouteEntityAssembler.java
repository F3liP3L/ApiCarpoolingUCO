package co.edu.uco.carpooling.service.assembler.entity.implementation;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RouteEntityAssembler implements EntityAssembler<RouteEntity, RouteDomain, RouteDTO> {
    private final ModelMapper modelMapper;

    public RouteEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public RouteDomain assembleDomain(RouteEntity entity) {
        return modelMapper.map(entity, RouteDomain.class);
    }

    @Override
    public RouteEntity assembleEntity(RouteDomain domain) {
        return modelMapper.map(domain, RouteEntity.class);
    }

    @Override
    public RouteDTO assembleDTO(RouteEntity entity) {
        return modelMapper.map(entity, RouteDTO.class);
    }
}
