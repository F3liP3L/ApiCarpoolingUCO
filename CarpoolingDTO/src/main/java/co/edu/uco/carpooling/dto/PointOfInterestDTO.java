package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class PointOfInterestDTO {
    private UUID id;
    private String name;
    private CityDTO city;

    public PointOfInterestDTO(UUID id, String name, CityDTO city) {
        setId(id);
        setCity(city);
        setName(name);
    }

    public PointOfInterestDTO() {
        setId(UtilUUID.getUtilUUID().getDefaultUUID(id));
        setName(EMPTY);
        setCity(CityDTO.create());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilObject.getUtilObject().getDefaultIsNull(id, UtilUUID.getUtilUUID().getNewUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = getUtilText().trim(name);
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = UtilObject.getUtilObject().getDefaultIsNull(city, CityDTO.create());
    }

    public static final PointOfInterestDTO create() {
        return new PointOfInterestDTO();
    }


}
