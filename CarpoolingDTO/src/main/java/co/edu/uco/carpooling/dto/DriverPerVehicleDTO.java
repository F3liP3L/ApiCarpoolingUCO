package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
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
    }

    public void setId(UUID id) {
        this.id = UtilObject.getUtilObject().getDefaultIsNull(id, UtilUUID.getUtilUUID().getNewUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = UtilText.getUtilText().getDefault(name);
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = UtilText.getUtilText().getDefault(nameVehicle);
    }

    public static final DriverPerVehicleDTO create() {
        return new DriverPerVehicleDTO();
    }

}
