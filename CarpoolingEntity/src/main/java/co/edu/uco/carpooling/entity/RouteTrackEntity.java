package co.edu.uco.carpooling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "routeTrack")
public class RouteTrackEntity {
    @Id
    private UUID id;
    private LocalDateTime routeTrackTime;
    private Integer latitude;
    private Integer longitude;
    private LocalDateTime routeCreationTime;
}
