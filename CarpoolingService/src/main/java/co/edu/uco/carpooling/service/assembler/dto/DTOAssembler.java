package co.edu.uco.carpooling.service.assembler.dto;

public interface DTOAssembler<D,T> {

    D assembleDomain(T dto);

    T assembleDto(D domain);

}
