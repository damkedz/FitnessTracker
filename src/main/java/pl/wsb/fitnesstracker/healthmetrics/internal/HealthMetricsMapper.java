package pl.wsb.fitnesstracker.healthmetrics.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetrics;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetricsDto;

@Component
class HealthMetricsMapper {

    HealthMetricsDto toDto(HealthMetrics user) {
        return new HealthMetricsDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail());
    }

    HealthMetrics toEntity(HealthMetricsDto userDto) {
        return new HealthMetrics(
                userDto.firstName(),
                userDto.lastName(),
                userDto.birthdate(),
                userDto.email());
    }

}
