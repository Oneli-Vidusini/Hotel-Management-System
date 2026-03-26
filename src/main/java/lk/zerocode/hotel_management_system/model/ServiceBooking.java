package lk.zerocode.hotel_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "service_bookings")
public class ServiceBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private LocalTime timeSlot;

    @OneToOne
    private Booking booking;

    @ManyToOne
    private ServiceItem serviceItems;
}
