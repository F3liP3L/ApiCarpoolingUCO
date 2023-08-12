package co.edu.uco.carpooling.dto;

import java.sql.Time;
import java.util.UUID;

public class RouteDTO {

    private UUID id;
//    private DriverPerVehicleDTO driverVehicle;
    private int routeCapacity;
    private PointOfInterestDTO pointOfInterest;
    private Time routeTime;
    private StatusDTO routeStatus;
}