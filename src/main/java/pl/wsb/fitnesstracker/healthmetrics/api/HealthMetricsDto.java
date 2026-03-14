package pl.wsb.fitnesstracker.healthmetrics.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;

import java.time.LocalDate;

public record HealthMetricsDto(@Nullable Long id, String firstName, String lastName,
                               @JsonFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
                               String email) {

}
