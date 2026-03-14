package pl.wsb.fitnesstracker.healthmetrics.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetrics;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetricsProvider;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetricsService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
class HealthMetricsServiceImpl implements HealthMetricsService, HealthMetricsProvider {

    private final HealthMetricsRepository userRepository;

    @Override
    public HealthMetrics createUser(final HealthMetrics user) {
        log.info("Creating User {}", user);
        if (user.getId() != null) {
            throw new IllegalArgumentException("User has already DB ID, update is not permitted!");
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<HealthMetrics> getUser(final Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<HealthMetrics> getUserByEmail(final String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<HealthMetrics> findAllUsers() {
        return userRepository.findAll();
    }

}