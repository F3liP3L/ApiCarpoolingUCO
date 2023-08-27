package co.edu.uco.carpooling.service.assembler.dto.implementation;

import co.edu.uco.carpooling.dto.StatusDTO;
import co.edu.uco.carpooling.service.assembler.dto.DTOAssembler;
import co.edu.uco.carpooling.service.domain.StatusDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StatusDTOAssembler implements DTOAssembler<StatusDomain, StatusDTO> {

    private final ModelMapper modelMapper;

    public StatusDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public StatusDomain assembleDomain(StatusDTO dto) {
        return modelMapper.map(dto, StatusDomain.class);
    }

    @Override
    public StatusDTO assembleDto(StatusDomain domain) {
        return modelMapper.map(domain, StatusDTO.class);
    }
}
