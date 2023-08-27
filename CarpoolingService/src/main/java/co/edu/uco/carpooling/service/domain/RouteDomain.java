package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.sql.Time;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilDate.TIME;
import static co.edu.uco.crosscutting.util.UtilDate.getUtilDate;
import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;


public class RouteDomain {
    private UUID id;
    private int routeCapacity;
    private PointOfInterestDomain pointOfInterest;
    private Time routeTime;
    private DriverPerVehicleDomain driverPerVehicle;
    private StatusDomain routeStatus;

    public RouteDomain(UUID id, DriverPerVehicleDomain driverPerVehicle, int routeCapacity, PointOfInterestDomain pointOfInterest, Time routeTime, StatusDomain routeStatus) {
        setId(id);
        setDriverPerVehicle(driverPerVehicle);
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
        setDriverPerVehicle(DriverPerVehicleDomain.build());
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

    public Time getRouteTime() {
        return routeTime;
    }

    public void setRouteTime(final Time routeTime) {
        this.routeTime = getUtilDate().getDefaultTimeIfNull(routeTime);
    }

    public DriverPerVehicleDomain getDriverPerVehicle() {
        return driverPerVehicle;
    }

    public void setDriverPerVehicle(DriverPerVehicleDomain driverPerVehicle) {
        this.driverPerVehicle = getUtilObject().getDefaultIsNull(driverPerVehicle, DriverPerVehicleDomain.build());
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

    public static final RouteDomain build(final UUID id, final DriverPerVehicleDomain driverPerVehicle, final int routeCapacity, final PointOfInterestDomain pointOfInterest, final Time routeTime, final StatusDomain routeStatus) {
        return new RouteDomain(id,driverPerVehicle,routeCapacity,pointOfInterest,routeTime,routeStatus);
    }
}
