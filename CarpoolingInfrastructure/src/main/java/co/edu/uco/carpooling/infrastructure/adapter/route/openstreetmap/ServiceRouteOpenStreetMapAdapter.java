package co.edu.uco.carpooling.infrastructure.adapter.route.openstreetmap;

import co.edu.uco.carpooling.crosscutting.util.json.MapperJsonObject;
import co.edu.uco.carpooling.infrastructure.adapter.route.openstreetmap.client.POIServiceClient;
import co.edu.uco.carpooling.service.domain.PositionDomain;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.route.ServiceRoutePort;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OpenStreetMapAdapter")
@Slf4j
public class ServiceRouteOpenStreetMapAdapter implements ServiceRoutePort {
    @Autowired
    private POIServiceClient serviceClient;
    @Override
    public RouteDomain buildRoute(PositionDomain origin, PositionDomain destination) {
        String positionOrigin = String.format("%s,%s", origin.getLatitude(), origin.getLongitude());
        String positionDestination = String.format("%s,%s", destination.getLatitude(), destination.getLongitude());
        extractRouteService(positionOrigin, positionDestination);
        return RouteDomain.build();
    }

    private String extractRouteService(String origin, String destination) {
        String queryPointRoute = "[out:json];" +
                "way(around:10, " + origin + ");" +
                "way(around:10, " + destination + ");" +
                "node(w);" + // Esto recupera los nodos de los caminos encontrados
                "out;";
        return serviceClient.getPOIsAlongRoute(queryPointRoute);
    }

    private void extractPosition(String jsonResponse) {
        // Parsea la respuesta JSON utilizando Gson
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

        // Obtén la matriz de elementos (nodos, caminos, relaciones)
        JsonArray elements = jsonObject.getAsJsonArray("elements");

        // Itera a través de los elementos para obtener información
        for (int i = 0; i < elements.size(); i++) {
            JsonObject element = elements.get(i).getAsJsonObject();

            // Obtén información común, como ID, latitud y longitud
            long id = element.get("id").getAsLong();
            double lat = element.get("lat").getAsDouble();
            double lon = element.get("lon").getAsDouble();

            // Aquí se puede agregar más atributos según tus necesidades
            // Para obtener el nombre del lugar, puedes buscar la etiqueta "name"
            String name = "";
            if (element.has("tags")) {
                JsonObject tags = element.getAsJsonObject("tags");
                if (tags.has("name")) {
                    name = tags.get("name").getAsString();
                }
            }
            log.info("ID: " + id);
            log.info("Latitud: " + lat);
            log.info("Longitud: " + lon);
            log.info("Nombre: " + name);
            log.info("------------------------");
        }
    }
}