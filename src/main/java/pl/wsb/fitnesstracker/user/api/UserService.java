package pl.wsb.fitnesstracker.user.api;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    List<UserDto> findAllUsers();

    List<UserBasicDto> findAllSimpleUsers();

    UserDto findUserById(Long id);

    UserDto findUserByEmail(String email);

    List<UserEmailDto> findUsersByEmail(String email);

    List<UserEmailDto> findUsersByEmailFragment(String emailFragment);

    List<UserDto> findUsersOlderThan(LocalDate date);

    List<UserDto> findUsersOlderThan(int age);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);
}