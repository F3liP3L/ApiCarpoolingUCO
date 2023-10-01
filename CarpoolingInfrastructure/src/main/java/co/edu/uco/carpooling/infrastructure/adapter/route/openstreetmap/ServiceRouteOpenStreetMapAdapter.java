package co.edu.uco.carpooling.infrastructure.adapter.route.openstreetmap;

import co.edu.uco.carpooling.crosscutting.util.MapperJsonObject;
import co.edu.uco.carpooling.infrastructure.adapter.route.openstreetmap.client.POIServiceClient;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.model.Position;
import co.edu.uco.carpooling.service.port.route.ServiceRoutePort;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceRouteOpenStreetMapAdapter  {
    /*
    @Autowired
    private POIServiceClient serviceClient;
    @Autowired
    private MapperJsonObject mapper;
    @Override
    public RouteDomain buildRoute(Position positionInit, Position positionFinal) {
        log.info(extractRouteService(6.1430789009693205, -75.37258843783178, 6.148838870261894, -75.36624577167204));
        //jsonToJsonObject(extractRouteService(6.1408891803542085, -75.37795313228223, 6.143063689117882, -75.37257936594409));
        return RouteDomain.build();
    }

    private String extractRouteService(double startLat, double startLon, double endLat, double endLon) {
        String queryPOI = "[out:json];" +
                "(" +
                "  way(around:100, " + startLat + ", " + startLon + ");" +
                "  way(around:100, " + endLat + ", " + endLon + ");" +
                ");" +
                "node(around:100, " + startLat + ", " + startLon + ");" +
                "out;";
        String queryPointRoute = "[out:json];" +
                "way(around:10, " + startLat + ", " + startLon + ");" +
                "way(around:10, " + endLat + ", " + endLon + ");" +
                "node(w);" + // Esto recupera los nodos de los caminos encontrados
                "out;";;
        return serviceClient.getPOIsAlongRoute(queryPointRoute);
    }

    private void extractPosition(String jsonResponse) {
        // Parsea la respuesta JSON utilizando Gson
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

        // Obtén la matriz de elementos (nodos, caminos, relaciones)
        JsonArray elements = jsonObject.getAsJsonArray("elements");

        // Itera a través de los elementos para obtener información
        for (int i = 0; i < elements.size(); i++) {
            JsonObject element = elements.get(i).getAsJsonObject();

            // Obtén información común, como ID, latitud y longitud
            long id = element.get("id").getAsLong();
            double lat = element.get("lat").getAsDouble();
            double lon = element.get("lon").getAsDouble();

            // Aquí puedes agregar más atributos según tus necesidades
            // Por ejemplo, para obtener el nombre del lugar, puedes buscar la etiqueta "name"
            String name = "";
            if (element.has("tags")) {
                JsonObject tags = element.getAsJsonObject("tags");
                if (tags.has("name")) {
                    name = tags.get("name").getAsString();
                }
            }
            System.out.println("ID: " + id);
            System.out.println("Latitud: " + lat);
            System.out.println("Longitud: " + lon);
            System.out.println("Nombre: " + name);
            System.out.println("------------------------");
        }
    }*/
}