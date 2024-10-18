package rabbit.ms.User.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rabbit.ms.User.dto.user.UserDTO;
import rabbit.ms.User.model.UserModel;
import rabbit.ms.User.service.UserService;

// Marks this class as a REST controller, which handles incoming HTTP requests.
@RestController
public class UserController {

    // Injects the UserService to handle user-related operations.
    @Autowired
    private UserService userService;

    // Maps POST requests to "/users" to this method.
    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserDTO userDTO) {

        // Convert UserDTO to UserModel using BeanUtils for property copying.
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);

        // Saves the UserModel and returns a response with status 201 (Created) and the saved user.
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}
