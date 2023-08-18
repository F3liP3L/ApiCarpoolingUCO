package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilDate;
import co.edu.uco.crosscutting.util.UtilNumeric;
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
        this.id = UtilObject.getUtilObject().getDefaultIsNull(id, UtilUUID.getUtilUUID().getNewUUID());
    }

    public RouteDTO getRoute() {
        return route;
    }

    public void setRoute(RouteDTO route) {
        this.route = UtilObject.getUtilObject().getDefaultIsNull(route, RouteDTO.create());
    }

    public Time getRouteTrackTime() {
        return routeTrackTime;
    }

    public void setRouteTrackTime(Time routeTrackTime) {
        this.routeTrackTime = UtilDate.getUtilDate().getDefaultTimeIfNull(routeTrackTime);
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = (Integer) UtilNumeric.getUtilNumeric().getDefault(latitude);
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = (Integer) UtilNumeric.getUtilNumeric().getDefault(longitude);
    }

    public Time getRouteCreationTime() {
        return routeCreationTime;
    }

    public void setRouteCreationTime(Time routeCreationTime) {
        this.routeCreationTime = UtilDate.getUtilDate().getDefaultTimeIfNull(routeCreationTime);
    }
}
