package co.edu.uco.carpooling.domain;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.crosscutting.util.UtilDate;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.sql.Time;
import java.util.UUID;



public class RouteTrackDomain {

    private UUID id;
    private RouteDTO route;
    private Time routeTrackTime;
    private int latitude;
    private int longitude;
    private Time routeCreationTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
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



    public void setLatitude(int latitude) {
        this.latitude = UtilNumeric.getUtilNumeric()
                .isLessThan(latitude , UtilNumeric.ZERO) ? UtilNumeric.ZERO : latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    public void setLongitude(int longitude) {
        this.longitude = UtilNumeric.getUtilNumeric()
                .isLessThan(longitude , UtilNumeric.ZERO) ? UtilNumeric.ZERO : longitude;
    }

    public Time getRouteCreationTime() {
        return routeTrackTime;
    }

    public void setRouteCreationTime(final Time routeCreationTime) {
        this.routeCreationTime = UtilDate.getUtilDate().getDefaultTimeIfNull(routeCreationTime);
    }

}