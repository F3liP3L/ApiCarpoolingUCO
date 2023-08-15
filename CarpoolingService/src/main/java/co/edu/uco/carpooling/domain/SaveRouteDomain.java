package co.edu.uco.carpooling.domain;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.crosscutting.util.UtilText;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class SaveRouteDomain {
    private UUID id;
    private String saveRoute;
    private RouteDTO route;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public String getSaveRoute() {
        return saveRoute;
    }

    public void setSaveRoute(String saveRoute) {this.saveRoute = UtilText.getUtilText().trim(saveRoute);}

    public RouteDTO getRoute() {
        return route;
    }

    public void setRoute(RouteDTO route) {this.route = route;}
}
