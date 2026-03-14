package pl.wsb.fitnesstracker.healthmetrics.api;

/**
 * Interface (API) for modifying operations on {@link HealthMetrics} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
public interface HealthMetricsService {

    /**
     * Creates a new user.
     *
     * @param user The user to be created
     * @return The created user
     */
    HealthMetrics createUser(HealthMetrics user);

}
