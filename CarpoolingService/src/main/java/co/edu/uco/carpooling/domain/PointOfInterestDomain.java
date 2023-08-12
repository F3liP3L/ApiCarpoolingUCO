package co.edu.uco.carpooling.domain;

import co.edu.uco.carpooling.dto.CityDTO;
import co.edu.uco.crosscutting.util.UtilText;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;

public class PointOfInterestDomain {

    private UUID id;
    private String pointOfInterestName;
    private CityDTO city;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
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
