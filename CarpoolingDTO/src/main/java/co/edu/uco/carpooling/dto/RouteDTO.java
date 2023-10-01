package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilDate.TIME;
import static co.edu.uco.crosscutting.util.UtilDate.getUtilDate;
import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;

public class RouteDTO {
    private UUID id;
    private DriverPerVehicleDTO driverVehicle;
    private int routeCapacity;
    private List<PositionDTO> positions;
    private List<PointOfInterestDTO> pointOfInterest;
    private LocalDateTime routeTime;
    private StatusDTO routeStatus;

    public RouteDTO(UUID id, DriverPerVehicleDTO driverVehicle, int routeCapacity, List<PointOfInterestDTO> pointOfInterest, LocalDateTime routeTime, StatusDTO routeStatus, List<PositionDTO> positions) {
        setId(id);
        setDriverVehicle(driverVehicle);
        setRouteCapacity(routeCapacity);
        setRouteStatus(routeStatus);
        setPositions(positions);
        setPointOfInterest(pointOfInterest);
        setRouteTime(routeTime);
    }

    public RouteDTO() {
        setId(UtilUUID.getUtilUUID().getDefaultUUIDIsEmpty(id));
        setPositions(new ArrayList<>());
        setPointOfInterest(new ArrayList<>());
        setRouteStatus(StatusDTO.create());
        setDriverVehicle(DriverPerVehicleDTO.create());
        setRouteCapacity(ZERO);
        setRouteTime(TIME);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
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
        this.routeCapacity = (int) getUtilNumeric().getDefaultNumber(routeCapacity);
    }

    public List<PointOfInterestDTO> getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(List<PointOfInterestDTO> pointOfInterest) {
        this.pointOfInterest = UtilObject.getUtilObject().getDefaultIsNull(pointOfInterest, new ArrayList<>());
    }

    public LocalDateTime getRouteTime() {
        return routeTime;
    }

    public void setRouteTime(LocalDateTime routeTime) {
        this.routeTime = getUtilDate().getDefaultTimeIfNull(routeTime);
    }

    public StatusDTO getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(StatusDTO routeStatus) {
        this.routeStatus = UtilObject.getUtilObject().getDefaultIsNull(routeStatus, StatusDTO.create());
    }

    public List<PositionDTO> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionDTO> positions) {
        this.positions = UtilObject.getUtilObject().getDefaultIsNull(positions, new ArrayList<>());
    }

    public static final RouteDTO create() {
        return new RouteDTO();
    }
}