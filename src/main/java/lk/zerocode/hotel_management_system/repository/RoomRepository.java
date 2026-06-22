package lk.zerocode.hotel_management_system.repository;

import lk.zerocode.hotel_management_system.model.Booking;
import lk.zerocode.hotel_management_system.model.Hotel;
import lk.zerocode.hotel_management_system.model.Room;
import lk.zerocode.hotel_management_system.model.RoomType;
import lk.zerocode.hotel_management_system.model.enums.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    Optional<Room> findByRoomNumber(Long roomNumber);

    Optional<Room> findRoomByHotel(Hotel hotel);

    Optional<Room> findRoomByRoomType(RoomType roomType);

    Optional<Room> findRoomByRoomStatus(RoomStatus roomStatus);

    @Query("""
        SELECT r
        FROM Room r
        WHERE r.id NOT IN (
            SELECT rb.room.id
            FROM RoomBooking rb
            WHERE rb.checkInTime < :checkOutTime
            AND rb.checkOutTime > :checkInTime
        )
    """)

    List<Room> findAvailableRooms(@Param("checkInTime") LocalDateTime checkInTime, @Param("checkOutTime") LocalDateTime checkOutTime);
}
