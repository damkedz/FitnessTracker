package pl.wsb.fitnesstracker.healthmetrics.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetricsDto;

import java.util.List;

/**
 * healthmetricsController is responsible for handling HTTP requests related to healthmetrics operations.
 * It provides endpoints for retrieving and creating healthmetricss.
 */
@RestController
@RequestMapping("/v1/healthmetricss")
@RequiredArgsConstructor
class HealthMetricsController {

    private final healthmetricsServiceImpl healthmetricsService;

    private final healthmetricsMapper healthmetricsMapper;

    @GetMapping
    public List<HealthMetricsDto> getAllhealthmetricss() {
        return healthmetricsService.findAllhealthmetricss()
                .stream()
                .map(healthmetricsMapper::toDto)
                .toList();
    }


    @PostMapping
    public HealthMetricsDto addhealthmetrics(@RequestBody HealthMetricsDto healthmetricsDto) throws InterruptedException {

        // TODO: Implement the method to add a new healthmetrics.
        //  You can use the @RequestBody annotation to map the request body to the healthmetricsDto object.

        return null;
    }

}