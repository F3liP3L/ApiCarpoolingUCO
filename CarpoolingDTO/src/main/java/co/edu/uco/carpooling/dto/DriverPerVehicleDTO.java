package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class DriverPerVehicleDTO {
    private UUID id;
    private String name;
    private String nameVehicle;
    public UUID getId() {
        return id;
    }
    public DriverPerVehicleDTO() {
        setId(UtilUUID.getUtilUUID().getDefaultUUID(id));
        setName(EMPTY);
        setNameVehicle(EMPTY);
    }

    public DriverPerVehicleDTO(UUID id, String name, String nameVehicle) {
        setId(id);
        setName(name);
        setNameVehicle(nameVehicle);
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

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = getUtilText().trim(nameVehicle);
    }

    public static final DriverPerVehicleDTO create() {
        return new DriverPerVehicleDTO();
    }

}
