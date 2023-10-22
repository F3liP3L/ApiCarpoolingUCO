package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.routesave;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.crosscutting.util.json.UtilMapperJson;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.broker.route.ReceiveRouteSavePort;
import co.edu.uco.carpooling.service.usecase.route.RegisterRouteUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ReceiveSaveRouteRabbitMQAdapter implements ReceiveRouteSavePort {
    @Autowired
    private UtilMapperJson mapperJson;
    @Autowired
    private RegisterRouteUseCase registerRouteUseCase;
    @Override
    @RabbitListener(queues = "${processor.queue.route.save-route}")
    public void execute(String message) {
        log.info(message);
        Optional<RouteDomain> route = mapperJson.execute(message, RouteDomain.class);
        if (route.isPresent()) {
            try {
                registerRouteUseCase.execute(route.get());
            } catch (CarpoolingCustomException exception) {
                log.error(exception.getUserMessage());
            }
        } else {
            log.error("A problem occurred when trying to read data from the queue to save a route.");
        }
    }
}
