package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.sql.Time;
import java.util.UUID;

public class RouteTrackDTO {
    private UUID id;
    private RouteDTO route;
    private Time routeTrackTime;
    private Integer latitude;
    private Integer longitude;
    private Time routeCreationTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilObject.getUtilObject().getDefaultIsNull(id, UtilUUID.DEFAULT_UUID);
    }

    public RouteDTO getRoute() {
        return route;
    }

    public void setRoute(RouteDTO route) {
        this.route = route;
    }

    public Time getRouteTrackTime() {
        return routeTrackTime;
    }

    public void setRouteTrackTime(Time routeTrackTime) {
        this.routeTrackTime = routeTrackTime;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Time getRouteCreationTime() {
        return routeCreationTime;
    }

    public void setRouteCreationTime(Time routeCreationTime) {
        this.routeCreationTime = routeCreationTime;
    }
}
