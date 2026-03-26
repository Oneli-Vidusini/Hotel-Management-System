package lk.zerocode.hotel_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double totalPrice;
    private String bookingStatus;

    @ManyToOne
    private User user;
}
