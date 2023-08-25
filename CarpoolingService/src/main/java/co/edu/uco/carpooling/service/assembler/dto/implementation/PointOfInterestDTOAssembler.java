package co.edu.uco.carpooling.service.assembler.dto.implementation;


import co.edu.uco.carpooling.dto.PointOfInterestDTO;
import co.edu.uco.carpooling.service.assembler.dto.DTOAssembler;
import co.edu.uco.carpooling.service.domain.PointOfInterestDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PointOfInterestDTOAssembler implements DTOAssembler<PointOfInterestDomain, PointOfInterestDTO> {
    private ModelMapper modelMapper;

    public PointOfInterestDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public PointOfInterestDomain assembleDomain(PointOfInterestDTO dto) {
        return modelMapper.map(dto, PointOfInterestDomain.class);
    }

    @Override
    public PointOfInterestDTO assembleDto(PointOfInterestDomain domain) {
        return modelMapper.map(domain, PointOfInterestDTO.class);
    }
}
