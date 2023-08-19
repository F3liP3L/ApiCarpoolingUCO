package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilDate;
import co.edu.uco.crosscutting.util.UtilNumeric;
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

    public RouteDTO(UUID id, DriverPerVehicleDTO driverVehicle, int routeCapacity, PointOfInterestDTO pointOfInterest, Time routeTime, StatusDTO routeStatus) {
        setId(id);
        setDriverVehicle(driverVehicle);
        setRouteCapacity(routeCapacity);
        setRouteStatus(routeStatus);
        setPointOfInterest(pointOfInterest);
        setRouteTime(routeTime);
    }

    public RouteDTO() {
        setId(UtilUUID.getUtilUUID().getDefaultUUID(id));
        setRouteCapacity(UtilNumeric.ZERO);
        setPointOfInterest(PointOfInterestDTO.create());
        setRouteStatus(StatusDTO.create());
        setDriverVehicle(DriverPerVehicleDTO.create());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilObject.getUtilObject().getDefaultIsNull(id, UtilUUID.getUtilUUID().getNewUUID());
    }

    public DriverPerVehicleDTO getDriverVehicle() {
        return driverVehicle;
    }

    public void setDriverVehicle(DriverPerVehicleDTO driverVehicle) {
        this.driverVehicle = UtilObject.getUtilObject().getDefaultIsNull(driverVehicle, DriverPerVehicleDTO.create());
    }

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public void setRouteCapacity(int routeCapacity) {
        this.routeCapacity = (int) UtilNumeric.getUtilNumeric().getDefault(routeCapacity);
    }

    public PointOfInterestDTO getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(PointOfInterestDTO pointOfInterest) {
        this.pointOfInterest = UtilObject.getUtilObject().getDefaultIsNull(pointOfInterest, PointOfInterestDTO.create());
    }

    public Time getRouteTime() {
        return routeTime;
    }

    public void setRouteTime(Time routeTime) {
        this.routeTime = UtilDate.getUtilDate().getDefaultTime(routeTime, UtilDate.TIME);
    }

    public StatusDTO getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(StatusDTO routeStatus) {
        this.routeStatus = UtilObject.getUtilObject().getDefaultIsNull(routeStatus, StatusDTO.create());
    }

    public static final RouteDTO create() {
        return new RouteDTO();
    }
}