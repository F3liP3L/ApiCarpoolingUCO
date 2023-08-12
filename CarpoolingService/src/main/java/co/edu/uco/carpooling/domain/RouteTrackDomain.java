package co.edu.uco.carpooling.domain;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.crosscutting.util.UtilDate;
import co.edu.uco.crosscutting.util.UtilNumeric;

import java.sql.Time;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;


public class RouteTrackDomain {

    private UUID id;
    private RouteDTO route;
    private Time routeTrackTime;
    private int latitud;
    private int longitud;
    private Time routeCreationTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
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

    public void setRouteTrackTime(final Time routeTrackTime) {
        this.routeTrackTime = UtilDate.getUtilDate().getDefaultTimeIfNull(routeTrackTime);
    }

    public double getLatitud() {
        return latitud;
    }


    public void setLatitud(int latitud) {
        this.latitud = UtilNumeric.getUtilNumeric()
                .isLessThan(latitud , UtilNumeric.ZERO)?UtilNumeric.ZERO : latitud;
    }

    public double getLongitud() {
        return longitud;
    }


    public void setLongitud(int longitud) {
        this.longitud = UtilNumeric.getUtilNumeric()
                .isLessThan(longitud , UtilNumeric.ZERO)?UtilNumeric.ZERO : longitud;
    }

    public Time getRouteCreationTime() {
        return routeTrackTime;
    }

    public void setRouteCreationTime(final Time routeCreationTime) {
        this.routeCreationTime = UtilDate.getUtilDate().getDefaultTimeIfNull(routeCreationTime);
    }

}