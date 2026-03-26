package lk.zerocode.hotel_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hotelName;
    private String location;
}
