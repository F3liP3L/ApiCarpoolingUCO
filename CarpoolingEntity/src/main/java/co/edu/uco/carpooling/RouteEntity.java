package co.edu.uco.carpooling;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
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
    private DriverPerVehicleEntity driverVehicle;
    private int routeCapacity;
    @ManyToOne
    private PointOfInterestEntity pointOfInterest;
    private Time routeTime;
    @ManyToOne
    @JoinColumn()
    private StatusEntity routeStatus;
}