package rabbit.ms.User.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Marks this class as a configuration class for Spring, indicating it contains bean definitions.
@Configuration
public class RabbitMQConfig {

    // Defines a bean for converting messages to and from JSON using Jackson.
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        // Creates an ObjectMapper instance, which is used by Jackson for JSON serialization and deserialization.
        ObjectMapper objectMapper = new ObjectMapper();
        // Returns a new Jackson2JsonMessageConverter that uses the ObjectMapper.
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
