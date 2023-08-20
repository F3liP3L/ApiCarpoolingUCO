package co.edu.uco.carpooling.service.assembler.dto.impl;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.assembler.dto.DTOAssembler;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RouteDTOAssembler implements DTOAssembler<RouteDomain, RouteDTO> {
    private final ModelMapper modelMapper;

    public RouteDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public RouteDomain assembleDomain(RouteDTO dto) {
        return modelMapper.map(dto, RouteDomain.class);
    }

    @Override
    public RouteDTO assembleDto(RouteDomain domain) {
        return modelMapper.map(domain, RouteDTO.class);
    }
}
