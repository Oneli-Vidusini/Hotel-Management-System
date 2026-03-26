package lk.zerocode.hotel_management_system.model;

import jakarta.persistence.*;
import lk.zerocode.hotel_management_system.model.enums.RoomStatus;
import lombok.Data;

@Data
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private RoomType roomType;
}
