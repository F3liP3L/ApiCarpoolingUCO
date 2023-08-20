package co.edu.uco.carpooling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pointInterest")
public class PointOfInterestEntity {
    @Id
    private UUID id;
    private String pointOfInterestName;
    @ManyToOne
    @JoinColumn(nullable = false)
    private CityEntity city;
}
