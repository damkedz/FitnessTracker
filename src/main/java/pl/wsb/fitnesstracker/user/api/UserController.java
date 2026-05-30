package pl.wsb.fitnesstracker.user.api;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/simple")
    List<UserBasicDto> getAllSimpleUsers() {
        return userService.findAllSimpleUsers();
    }

    @GetMapping("/email")
    List<UserEmailDto> getUsersByEmail(@RequestParam String email) {
        return userService.findUsersByEmail(email);
    }

    @GetMapping("/by-email")
    UserDto getUserByEmail(@RequestParam String email) {
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

    @GetMapping("/older/{time}")
    List<UserDto> getUsersOlderThanDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate time
    ) {
        return userService.findUsersOlderThan(time);
    }

    @GetMapping("/older-than/{age}")
    List<UserDto> getUsersOlderThanAge(@PathVariable int age) {
        return userService.findUsersOlderThan(age);
    }

    @GetMapping("/{id}")
    UserDto getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
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