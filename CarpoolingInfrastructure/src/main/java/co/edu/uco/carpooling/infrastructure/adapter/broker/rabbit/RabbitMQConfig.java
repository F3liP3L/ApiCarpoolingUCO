package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {
    @Value("${processor.queue.route.response-create}")
    private String responseCreateRouteQueue;
    @Value("${processor.queue.route.save-route}")
    private String saveRouteQueue;
    @Value("${processor.queue.route.save-routing-key}")
    private String saveRoutingKey;
    @Value("${processor.queue.route.create-routing-key}")
    private String responseCreateRoutingKey;
    @Value("${processor.exchange.route}")
    private String routeExchange;
    @Bean
    public Queue requestRoute() {
        return new Queue(responseCreateRouteQueue);
    }
    @Bean
    public Queue saveRoute() { return new Queue(saveRouteQueue); }
    @Bean
    public DirectExchange routeExchange(){
        return new DirectExchange(routeExchange);
    }
    @Bean
    public Binding routeRequestBinding(){
        return BindingBuilder.bind(requestRoute())
                .to(routeExchange())
                .with(responseCreateRoutingKey);
    }
    @Bean
    public Binding routeSaveBinding() {
        return BindingBuilder.bind(saveRoute())
                .to(routeExchange())
                .with(saveRoutingKey);
    }
}
