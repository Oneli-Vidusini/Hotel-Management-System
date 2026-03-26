package lk.zerocode.hotel_management_system.model;

import jakarta.persistence.*;
import lk.zerocode.hotel_management_system.model.enums.RoomTypeName;
import lombok.Data;

@Data
@Entity
@Table(name = "room_types")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private RoomTypeName roomTypeName;
    private long roomTypeCapacity;
    private double basicPrice;
}
