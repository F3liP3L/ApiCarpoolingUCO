package co.edu.uco.carpooling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "route")
public class RouteEntity {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private DriverPerVehicleEntity driverVehicle;
    private int routeCapacity;
    @ManyToOne
    @JoinColumn(nullable = false)
    private PointOfInterestEntity pointOfInterest;
    private LocalDateTime routeTime;
    @ManyToOne
    @JoinColumn(nullable = false)
    private StatusEntity routeStatus;
}