package co.edu.uco.carpooling.domain;

import co.edu.uco.carpooling.dto.PointOfInterestDTO;
import co.edu.uco.carpooling.dto.StatusDTO;
import co.edu.uco.crosscutting.util.UtilDate;
import co.edu.uco.crosscutting.util.UtilNumeric;

import java.sql.Time;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;

public class RouteDomain {

    private UUID id;
//    private DriverPerVehicleDTO driverVehicle;
    private int routeCapacity;
    private PointOfInterestDTO pointOfInterest;
    private Time routeTime;
    private StatusDTO routeStatus;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

//    public DriverPerVehicleDTO getDriverVehicle() {
//        return driverVehicle;
//    }
//
//    public void setDriverVehicle(DriverPerVehicleDTO driverVehicle) {
//        this.driverVehicle = driverVehicle;
//    }

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public final void setRouteCapacity(final int capacity) {
        this.routeCapacity = UtilNumeric.getUtilNumeric()
                .isLessThan(routeCapacity,UtilNumeric.ZERO)? UtilNumeric.ZERO: routeCapacity;
    }

    public PointOfInterestDTO getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(PointOfInterestDTO pointOfInterest) {
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
