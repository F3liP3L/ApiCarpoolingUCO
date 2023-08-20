package co.edu.uco.carpooling.service.assembler.entity;

public interface EntityAssembler<E,D> {

    D assembleDomain(D domain);
    E assembleEntity(E entity);

}
