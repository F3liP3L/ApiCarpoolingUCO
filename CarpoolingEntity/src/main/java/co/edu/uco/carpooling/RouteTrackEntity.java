package co.edu.uco.carpooling;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "routTrack")
public class RouteTrackEntity {
    @Id
    private UUID id;
    private Time routeTrackTime;
    private Integer latitude;
    private Integer longitude;
    private Date routeCreationTime;
}
