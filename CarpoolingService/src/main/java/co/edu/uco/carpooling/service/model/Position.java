package co.edu.uco.carpooling.service.model;

import co.edu.uco.crosscutting.util.UtilText;

public class Position {
    private String latitude;
    private String longitude;
    private String altitude;
    public Position(String latitude, String longitude) {
        setLatitude(latitude);
        setLongitude(longitude);
        setAltitude(UtilText.EMPTY);
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = UtilText.getUtilText().trim(latitude);
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = UtilText.getUtilText().trim(longitude);
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = UtilText.getUtilText().trim(altitude);
    }
}
