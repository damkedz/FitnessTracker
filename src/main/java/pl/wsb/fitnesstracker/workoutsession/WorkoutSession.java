package pl.wsb.fitnesstracker.workoutsession;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.training.api.Training;

import java.time.LocalDateTime;

@Entity
@Table(name = "workout_session")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "start_latitude", nullable = false)
    private double startLatitude;

    @Column(name = "start_longitude", nullable = false)
    private double startLongitude;

    @Column(name = "end_latitude", nullable = false)
    private double endLatitude;

    @Column(name = "end_longitude", nullable = false)
    private double endLongitude;

    @Column(nullable = false)
    private double altitude;

    public WorkoutSession(
            final Training training,
            final LocalDateTime timestamp,
            final double startLatitude,
            final double startLongitude,
            final double endLatitude,
            final double endLongitude,
            final double altitude) {
        this.training = training;
        this.timestamp = timestamp;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.endLatitude = endLatitude;
        this.endLongitude = endLongitude;
        this.altitude = altitude;
    }
}