package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilDate.TIME;
import static co.edu.uco.crosscutting.util.UtilDate.getUtilDate;
import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

public class RouteDomain {
    private UUID id;
    private DriverPerVehicleDomain driverVehicle;
    private int routeCapacity;
    private PointOfInterestDomain pointOfInterest;
    private LocalDateTime routeTime;
    private StatusDomain routeStatus;

    public RouteDomain(UUID id, DriverPerVehicleDomain driverVehicle, int routeCapacity, PointOfInterestDomain pointOfInterest, LocalDateTime routeTime, StatusDomain routeStatus) {
        setId(id);
        setDriverVehicle(driverVehicle);
        setRouteCapacity(routeCapacity);
        setRouteStatus(routeStatus);
        setPointOfInterest(pointOfInterest);
        setRouteTime(routeTime);
    }

    public RouteDomain() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setRouteCapacity(ZERO);
        setPointOfInterest(PointOfInterestDomain.build());
        setRouteStatus(StatusDomain.build());
        setDriverVehicle(DriverPerVehicleDomain.build());
        setRouteTime(TIME);
    }

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
        this.routeCapacity = getUtilNumeric()
                .isLessThan(capacity, ZERO) ? ZERO: capacity;
    }

    public PointOfInterestDomain getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(PointOfInterestDomain pointOfInterest) {
        this.pointOfInterest = pointOfInterest;
    }

    public LocalDateTime getRouteTime() {
        return routeTime;
    }

    public void setRouteTime(final LocalDateTime routeTime) {
        this.routeTime = getUtilDate().getDefaultTimeIfNull(routeTime);
    }

    public DriverPerVehicleDomain getDriverVehicle() {
        return driverVehicle;
    }

    public void setDriverVehicle(DriverPerVehicleDomain driverVehicle) {
        this.driverVehicle = getUtilObject().getDefaultIsNull(driverVehicle, DriverPerVehicleDomain.build());
    }

    public StatusDomain getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(StatusDomain routeStatus) {
        this.routeStatus = getUtilObject().getDefaultIsNull(routeStatus, StatusDomain.build());
    }

    public static final RouteDomain build() {
        return new RouteDomain();
    }

    public static final RouteDomain build(final UUID id, final DriverPerVehicleDomain driverPerVehicle, final int routeCapacity, final PointOfInterestDomain pointOfInterest, final LocalDateTime routeTime, final StatusDomain routeStatus) {
        return new RouteDomain(id,driverPerVehicle,routeCapacity,pointOfInterest,routeTime,routeStatus);
    }
}
