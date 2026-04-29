package lk.zerocode.hotel_management_system.repository;

import lk.zerocode.hotel_management_system.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    Optional<Hotel> findByHotelName(String hotelName);
}
