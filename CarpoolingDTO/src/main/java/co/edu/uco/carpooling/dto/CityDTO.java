package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class CityDTO {
    private UUID id;
    private String name;

    public CityDTO(final UUID id,final String name) {
        setId(id);
        setName(name);
    }

    public CityDTO() {
        setId(UtilUUID.getUtilUUID().getDefaultUUID(id));
        setName(UtilText.getUtilText().getDefault(UtilText.EMPTY));
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
}
