package co.edu.uco.carpooling.service.assembler.entity;

public interface EntityAssembler<E,D> {

    D assembleDomain(E entity);
    E assembleEntity(E domain);

}
