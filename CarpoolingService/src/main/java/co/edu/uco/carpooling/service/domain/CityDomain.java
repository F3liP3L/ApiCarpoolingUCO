package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class CityDomain {

    private UUID id;
    private String name;
    private StateDomain state;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = UtilText.getUtilText().trim(name);}

}
