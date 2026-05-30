package pl.wsb.fitnesstracker.user.api;

import java.util.List;

public interface UserService {

    List<UserBasicDto> findAllUsers();

    UserDto findUserById(Long id);

    UserDto findUserByEmail(String email);

    List<UserEmailDto> findUsersByEmailFragment(String emailFragment);

    List<UserDto> findUsersOlderThan(int age);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);
}