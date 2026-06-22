package lk.zerocode.hotel_management_system.controller;

import lk.zerocode.hotel_management_system.controller.request.RoomRequestDTO;
import lk.zerocode.hotel_management_system.controller.response.RoomResponseDTO;
import lk.zerocode.hotel_management_system.model.Hotel;
import lk.zerocode.hotel_management_system.model.RoomType;
import lk.zerocode.hotel_management_system.model.enums.RoomStatus;
import lk.zerocode.hotel_management_system.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class RoomController {
    private RoomService  roomService;

    @PostMapping(value = "/rooms")
    public void createRoom(@RequestBody RoomRequestDTO roomRequestDTO) {
        roomService.createRoom(roomRequestDTO);
    }

    @GetMapping(value = "/rooms")
    public List<RoomRequestDTO> getAllRooms(@RequestBody RoomRequestDTO roomRequestDTO) {
        return roomService.getAllRooms();
    }
    @GetMapping(value = "/{id}/rooms")
    public RoomRequestDTO getRoomByID(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    @GetMapping(value = "/{roomNumber}/roomNumber/rooms")
    public RoomRequestDTO getRoomByRoomNumber(@PathVariable Long roomNumber){
        return roomService.getRoomByRoomNumber(roomNumber);
    }

    @GetMapping(value = "/{hotel}/hotel/rooms")
    public RoomRequestDTO getRoomByHotel(@RequestBody Hotel hotel){
        return roomService.getRoomByHotel(hotel);
    }

    @GetMapping(value = "/{roomType}/roomType/rooms")
    public RoomRequestDTO getRoomByRoomType(@RequestBody RoomType roomType){
        return roomService.getRoomByRoomType(roomType);
    }

    @GetMapping(value = "/{roomStatus}/roomStatus/rooms")
    public RoomRequestDTO getRoomByRoomStatus(@RequestBody RoomStatus roomStatus){
        return roomService.getRoomByRoomStatus(roomStatus);
    }

    @GetMapping(value = "/rooms/available")
    public List<RoomResponseDTO> getAvailableRooms(@RequestParam LocalDateTime checkInTime, @RequestParam LocalDateTime checkOutTime){
        return roomService.getAvailableRooms(checkInTime,checkOutTime);
    }
}
