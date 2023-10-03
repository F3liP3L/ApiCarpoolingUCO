package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${carpooling.queue.save-route}")
    private String saveRouteQueue;

    @Value("${carpooling.exchange.route}")
    private String routeExchange;
    @Bean
    public Queue saveRouteQueue() {
        return new Queue(saveRouteQueue);
    }
}
