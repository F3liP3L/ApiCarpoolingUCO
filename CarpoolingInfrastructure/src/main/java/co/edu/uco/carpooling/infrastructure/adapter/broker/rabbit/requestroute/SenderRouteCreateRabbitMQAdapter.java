package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.requestroute;

import co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.component.RabbitMQConfigureMessage;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.broker.route.SenderRouteCreatePort;
import co.edu.uco.crosscutting.util.UtilObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SenderRouteCreateRabbitMQAdapter implements SenderRouteCreatePort {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${hola}")
    private String hola;
    @Autowired
    private RabbitMQConfigureMessage configureMessage;
    @Value("${processor.queue.route.create-routing-key}")
    private String responseCreateRoutingKey;
    @Value("${processor.exchange.route}")
    private String routeExchange;
    @Override
    public void execute(RouteDomain message, String id) {
        MessageProperties propertiesMessage = configureMessage.generate(id);
        Optional<Message> bodyMessage = configureMessage.getBodyMessage(message, propertiesMessage);
        if (bodyMessage.isEmpty()) {
            return;
        }
        System.out.println(UtilObject.getUtilObject().getDefaultIsNull(hola, new String("Holaaaaa")));
        rabbitTemplate.convertAndSend(routeExchange, responseCreateRoutingKey, bodyMessage.get());
    }
}
