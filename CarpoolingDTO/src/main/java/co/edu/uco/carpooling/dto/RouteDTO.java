package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.sql.Time;
import java.util.UUID;

public class RouteDTO {

    private UUID id;
    private DriverPerVehicleDTO driverVehicle;
    private int routeCapacity;
    private PointOfInterestDTO pointOfInterest;
    private Time routeTime;
    private StatusDTO routeStatus;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilObject.getUtilObject().getDefaultIsNull(id, UtilUUID.DEFAULT_UUID);
    }

    public DriverPerVehicleDTO getDriverVehicle() {
        return driverVehicle;
    }

    public void setDriverVehicle(DriverPerVehicleDTO driverVehicle) {
        this.driverVehicle = driverVehicle;
    }

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public void setRouteCapacity(int routeCapacity) {
        this.routeCapacity = routeCapacity;
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

    public void setRouteTime(Time routeTime) {
        this.routeTime = routeTime;
    }

    public StatusDTO getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(StatusDTO routeStatus) {
        this.routeStatus = routeStatus;
    }
}