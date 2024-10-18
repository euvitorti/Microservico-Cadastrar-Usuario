package rabbit.ms.User.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbit.ms.User.model.UserModel;
import rabbit.ms.User.producers.UserProducer;
import rabbit.ms.User.repository.IUserRepository;

// Marks this class as a service, which contains business logic.
@Service
public class UserService {

    // Injects the user repository to handle database operations.
    @Autowired
    private IUserRepository iUserRepository;

    // Injects the UserProducer to send messages to the message broker.
    @Autowired
    private UserProducer userProducer;

    // This method saves a UserModel and publishes a message to the broker.
    @Transactional
    public UserModel save(UserModel userModel) {
        // Saves the user model to the database and returns the persisted entity.
        userModel = iUserRepository.save(userModel);

        // Publishes a message to the queue after saving the user.
        userProducer.publishMessage(userModel);
        return userModel; // Returns the saved user model.
    }
}
