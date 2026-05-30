package pl.wsb.fitnesstracker.user.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<UserBasicDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    UserDto getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/by-email")
    UserDto getUserByEmail(@RequestParam String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/email/{email}")
    UserDto getUserByEmailFromPath(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/search")
    List<UserEmailDto> searchUsersByEmail(@RequestParam String email) {
        return userService.findUsersByEmailFragment(email);
    }

    @GetMapping("/search/email/{email}")
    List<UserEmailDto> searchUsersByEmailFromPath(@PathVariable String email) {
        return userService.findUsersByEmailFragment(email);
    }

    @GetMapping("/older-than/{age}")
    List<UserDto> getUsersOlderThan(@PathVariable int age) {
        return userService.findUsersOlderThan(age);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("/{id}")
    UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @PatchMapping("/{id}")
    UserDto patchUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}