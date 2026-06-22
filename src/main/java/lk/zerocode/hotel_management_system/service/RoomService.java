package lk.zerocode.hotel_management_system.service;

import lk.zerocode.hotel_management_system.controller.request.RoomRequestDTO;
import lk.zerocode.hotel_management_system.controller.response.RoomResponseDTO;
import lk.zerocode.hotel_management_system.model.Hotel;
import lk.zerocode.hotel_management_system.model.RoomType;
import lk.zerocode.hotel_management_system.model.enums.RoomStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomService {
    public void createRoom(RoomRequestDTO roomRequestDTO);

    List<RoomRequestDTO> getAllRooms();

    RoomRequestDTO getRoomById(Long id);

    RoomRequestDTO getRoomByRoomNumber(Long roomNumber);

    RoomRequestDTO getRoomByHotel(Hotel hotel);

    RoomRequestDTO getRoomByRoomType(RoomType roomType);

    RoomRequestDTO getRoomByRoomStatus(RoomStatus roomStatus);

    List<RoomResponseDTO> getAvailableRooms(LocalDateTime checkInTime, LocalDateTime checkOutTime);
}
