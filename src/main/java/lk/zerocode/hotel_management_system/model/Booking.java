package lk.zerocode.hotel_management_system.model;

import jakarta.persistence.*;
import lk.zerocode.hotel_management_system.model.enums.BookingStatus;
import lk.zerocode.hotel_management_system.model.enums.ServiceType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double totalPrice;


    @ManyToOne
    private User user;
}
