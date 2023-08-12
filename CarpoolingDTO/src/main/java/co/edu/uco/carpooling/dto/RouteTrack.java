package co.edu.uco.carpooling.dto;

import java.sql.Time;
import java.util.UUID;

public class RouteTrack {
    private UUID id;
    private RouteDTO route;
    private Time routeTrackTime;
    private Integer latitud;
    private Integer longitud;
    private Time routeCreationTime;
}
