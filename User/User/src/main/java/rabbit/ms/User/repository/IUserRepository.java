package rabbit.ms.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rabbit.ms.User.model.UserModel;

public interface IUserRepository extends JpaRepository<UserModel, Long> {
}
