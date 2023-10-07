package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.requestroute;

import co.edu.uco.carpooling.crosscutting.util.json.UtilMapperJson;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.broker.route.RequestRoutePort;
import co.edu.uco.carpooling.service.usecase.route.CreateRouteUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ReceiverRequestRouteRabbitMQAdapter implements RequestRoutePort {
    @Autowired
    private UtilMapperJson mapperJson;
    @Autowired
    private CreateRouteUseCase createRouteUseCase;
    @Override
    @RabbitListener(queues = "${processor.queue.route.request}")
    public void execute(String message) {
        Optional<RouteDomain> route = mapperJson.execute(message, RouteDomain.class);
       if (route.isPresent()) {
           log.info(route.get().toString());
           createRouteUseCase.execute(route.get());
        } else {
           log.error("A problem has occurred trying to read data from the route request queue.");
       }

    }
}
