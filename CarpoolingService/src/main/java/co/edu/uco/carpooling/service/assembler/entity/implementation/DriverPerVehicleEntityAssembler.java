package co.edu.uco.carpooling.service.assembler.entity.implementation;

import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.entity.DriverPerVehicleEntity;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.domain.DriverPerVehicleDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class DriverPerVehicleEntityAssembler implements EntityAssembler<DriverPerVehicleEntity, DriverPerVehicleDomain, DriverPerVehicleDTO> {
    private final ModelMapper modelMapper;

    public DriverPerVehicleEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public DriverPerVehicleDomain assembleDomain(DriverPerVehicleEntity entity) {
        return modelMapper.map(entity, DriverPerVehicleDomain.class);
    }

    @Override
    public DriverPerVehicleEntity assembleEntity(DriverPerVehicleDomain domain) {
        return modelMapper.map(domain, DriverPerVehicleEntity.class);
    }

    @Override
    public DriverPerVehicleDTO assembleDTO(DriverPerVehicleEntity entity) {
        return modelMapper.map(entity, DriverPerVehicleDTO.class);
    }
}
