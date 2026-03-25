package lk.zerocode.hotel_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "room_types")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String roomTypeName;
    private long roomTypeCapacity;
    private double basicPrice;
}
