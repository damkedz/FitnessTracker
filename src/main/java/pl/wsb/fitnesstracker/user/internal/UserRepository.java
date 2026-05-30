package pl.wsb.fitnesstracker.user.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    default Optional<User> findByEmailIgnoreCase(String email) {
        return findAll()
                .stream()
                .filter(user -> user.getEmail() != null)
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    default List<User> findAllByEmailIgnoreCase(String email) {
        return findAll()
                .stream()
                .filter(user -> user.getEmail() != null)
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .toList();
    }

    default List<User> findByEmailContainingIgnoreCase(String emailFragment) {
        return findAll()
                .stream()
                .filter(user -> user.getEmail() != null)
                .filter(user -> user.getEmail().toLowerCase().contains(emailFragment.toLowerCase()))
                .toList();
    }

    default List<User> findOlderThan(LocalDate date) {
        return findAll()
                .stream()
                .filter(user -> user.getBirthdate() != null)
                .filter(user -> user.getBirthdate().isBefore(date))
                .toList();
    }

    default List<User> findOlderThan(int age) {
        LocalDate borderDate = LocalDate.now().minusYears(age);

        return findOlderThan(borderDate);
    }
}