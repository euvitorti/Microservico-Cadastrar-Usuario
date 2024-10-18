package rabbit.ms.User.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import rabbit.ms.User.dto.email.EmailDTO;
import rabbit.ms.User.model.UserModel;

// Marks this class as a Spring-managed component responsible for producing and sending messages.
@Component
public class UserProducer {

    // Injects RabbitTemplate to interact with RabbitMQ (for sending messages).
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // Injects the name of the RabbitMQ queue from the application properties (broker.queue.email.name).
    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    // This method publishes a message to RabbitMQ for a specific user.
    public void publishMessage(UserModel userModel) {

        // Formats the email body with the user's name using String's format method.
        String text = String.format("""
               Olá %s,
               Agradecemos pelo seu interesse e pela confiança em escolher nós como uma empresa para se trabalhar.
               Nos preocupamos com a experiência de todos que têm contato com nossa marca, por isso
               informamos que a posição Junior Desenvolvedor Java,
               para a qual você se candidatou foi preenchida por outra pessoa candidata.
              """, userModel.getName());

        // Creates a new EmailDTO object to structure the email message data.
        var emailDTO = new EmailDTO();
        emailDTO.setUserId(userModel.getUserId());  // Sets the user ID.
        emailDTO.setEmailTo(userModel.getEmail());  // Sets the recipient's email.
        emailDTO.setSubject("Agradecemos sua candidatura na oportunidade!");  // Sets the email subject.
        emailDTO.setText(text);  // Sets the email body text.

        // Sends the message to RabbitMQ.
        // The exchange is set to an empty string, meaning the default exchange is used.
        // "routingKey" is the queue name from the properties file, where the message will be routed.
        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}
