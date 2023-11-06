package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.routeactivate;

import co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.component.RabbitMQConfigureMessage;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.broker.route.SenderActivateRoutePort;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SenderRouteActivateRabbitMQAdapter implements SenderActivateRoutePort {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitMQConfigureMessage rabbitMQConfigureMessage;
    @Value("${processor.queue.route.get-activate-routing-key}")
    private String getActivateRouteKey;
    @Value("${processor.exchange.route}")
    private String routeExchange;
    @Override
    public void execute(RouteDomain message, String id) {
        MessageProperties messageProperties = rabbitMQConfigureMessage.generate(id);
        Optional<Message> bodyMessage = rabbitMQConfigureMessage.getBodyMessage(message, messageProperties);
        if (bodyMessage.isEmpty()) {
            return;
        }
        rabbitTemplate.convertAndSend(routeExchange,getActivateRouteKey,bodyMessage.get());
    }
}
