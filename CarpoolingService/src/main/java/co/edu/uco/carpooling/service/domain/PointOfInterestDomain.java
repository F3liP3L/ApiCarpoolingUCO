package co.edu.uco.carpooling.service.domain;

import co.edu.uco.carpooling.dto.CityDTO;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class PointOfInterestDomain {

    private UUID id;
    private String pointOfInterestName;
    private CityDTO city;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getPointOfInterestName() {return pointOfInterestName;}

    public void setPointOfInterestName(String pointOfInterestName) {
        this.pointOfInterestName = UtilText.getUtilText().trim(pointOfInterestName);
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

}
