package co.edu.uco.carpooling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
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
    @ElementCollection
    @CollectionTable(name = "point_of_interest", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "pointOfInterest")
    private List<String> pointOfInterest;
    @Lob
    private String positions;
    private LocalDateTime routeTime;
    @ManyToOne
    @JoinColumn(nullable = false)
    private StatusEntity routeStatus;
}