package co.edu.uco.carpooling.service.assembler.dto.implementation;

import co.edu.uco.carpooling.dto.CityDTO;
import co.edu.uco.carpooling.service.assembler.dto.DTOAssembler;
import co.edu.uco.carpooling.service.domain.CityDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CityDTOAssembler implements DTOAssembler<CityDomain, CityDTO> {
    private final ModelMapper modelMapper;
    public CityDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public CityDomain assembleDomain(CityDTO dto) {
        return modelMapper.map(dto, CityDomain.class);
    }

    @Override
    public CityDTO assembleDto(CityDomain domain) {
        return modelMapper.map(domain, CityDTO.class);
    }
}
