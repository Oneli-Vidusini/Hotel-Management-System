package lk.zerocode.hotel_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service_items")
public class ServiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String serviceItemName;
    private String capacity;
    private double basicPrice;

    @ManyToOne
    private HotelService hotelService;
}
