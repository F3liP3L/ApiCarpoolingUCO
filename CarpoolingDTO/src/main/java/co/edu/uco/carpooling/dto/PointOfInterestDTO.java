package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilObject.getUtilObject().getDefaultIsNull(id, UtilUUID.DEFAULT_UUID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = UtilText.getUtilText().getDefault(name, UtilText.EMPTY);
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
}
