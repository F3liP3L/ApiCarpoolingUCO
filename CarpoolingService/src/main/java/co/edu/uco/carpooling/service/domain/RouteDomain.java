package co.edu.uco.carpooling.service.domain;

import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.dto.StatusDTO;
import co.edu.uco.crosscutting.util.UtilDate;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.sql.Time;
import java.util.UUID;


public class RouteDomain {

    private UUID id;
    private DriverPerVehicleDTO driverVehicle;
    private int routeCapacity;
    private PointOfInterestDomain pointOfInterest;
    private Time routeTime;
    private StatusDTO routeStatus;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public final void setRouteCapacity(final int capacity) {
        this.routeCapacity = UtilNumeric.getUtilNumeric()
                .isLessThan(routeCapacity, UtilNumeric.ZERO)? UtilNumeric.ZERO: routeCapacity;
    }

    public PointOfInterestDomain getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(PointOfInterestDomain pointOfInterest) {
        this.pointOfInterest = pointOfInterest;
    }

    public Time getRouteTime() {
        return routeTime;
    }

    public void setRouteTime(final Time routeTime) {
        this.routeTime = UtilDate.getUtilDate().getDefaultTimeIfNull(routeTime);
    }

    public StatusDTO getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(StatusDTO routeStatus) {
        this.routeStatus = routeStatus;
    }


}
