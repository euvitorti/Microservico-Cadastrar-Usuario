package rabbit.ms.User.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

// Marks this class as an entity that maps to a table in the database.
@Entity
// Specifies the name of the table as "TB_USERS".
@Table(name = "TB_USERS")
public class UserModel implements Serializable {

    // Serial version UID for ensuring version compatibility during the serialization process.
    private static final long serialVersionUID = 1L;

    // Specifies that "userId" is the primary key of the entity.
    @Id
    // Automatically generates the ID using the AUTO strategy, which typically lets the database handle the generation.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;  // UUID is used for a unique identifier.

    // Stores the user's name.
    private String name;

    // Stores the user's email address.
    private String email;

    // Getter and Setter methods to provide controlled access to private fields.

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
