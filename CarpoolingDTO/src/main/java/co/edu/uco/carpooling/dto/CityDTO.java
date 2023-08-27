package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class CityDTO {
    private UUID id;
    private String name;

    public CityDTO(final UUID id, final String name) {
        setId(id);
        setName(name);
    }

    public CityDTO() {
        setId(UtilUUID.getUtilUUID().getDefaultUUID(id));
        setName(EMPTY);
    }

    public static CityDTO create() {
        return new CityDTO();
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
}
