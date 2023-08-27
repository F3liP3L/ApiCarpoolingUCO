package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.sql.Time;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilDate.getUtilDate;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;

public class RouteTrackDTO {
    private UUID id;
    private RouteDTO route;
    private Time routeTrackTime;
    private Integer latitude;
    private Integer longitude;
    private Time routeCreationTime;

    public RouteTrackDTO(UUID id, RouteDTO route, Time routeTrackTime, Integer latitude, Integer longitude, Time routeCreationTime) {
        setId(id);
        setRoute(route);
        setRouteTrackTime(routeTrackTime);
        setLatitude(latitude);
        setLongitude(longitude);
        setRouteCreationTime(routeCreationTime);
    }

    public RouteTrackDTO() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
    }

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
        this.routeTrackTime = getUtilDate().getDefaultTimeIfNull(routeTrackTime);
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = (Integer) getUtilNumeric().getDefaultNumber(latitude);
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = (Integer) getUtilNumeric().getDefaultNumber(longitude);
    }

    public Time getRouteCreationTime() {
        return routeCreationTime;
    }

    public void setRouteCreationTime(Time routeCreationTime) {
        this.routeCreationTime = getUtilDate().getDefaultTimeIfNull(routeCreationTime);
    }
}
