package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit;

import co.edu.uco.carpooling.crosscutting.util.UtilMapperJson;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BrokerReceiverRabbitMQAdapter {
    @Autowired
    private UtilMapperJson mapperJson;

    @RabbitListener(queues = "${processor.queue.route.request}")
    public void receiverMessage(String object) {
        System.out.println(object);
        Optional<RouteDomain> route = mapperJson.execute(object, RouteDomain.class);
        System.out.println(route.get());
    }
}
