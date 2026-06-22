package lk.zerocode.hotel_management_system.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lk.zerocode.hotel_management_system.controller.request.RoomRequestDTO;
import lk.zerocode.hotel_management_system.controller.response.RoomResponseDTO;
import lk.zerocode.hotel_management_system.model.Hotel;
import lk.zerocode.hotel_management_system.model.Room;
import lk.zerocode.hotel_management_system.model.RoomType;
import lk.zerocode.hotel_management_system.model.enums.RoomStatus;
import lk.zerocode.hotel_management_system.repository.RoomRepository;
import lk.zerocode.hotel_management_system.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;

    @Override
    public void createRoom(RoomRequestDTO  roomRequestDTO){
        Room room = new Room();
        room.setRoomNumber(roomRequestDTO.getRoomNumber());
        room.setRoomStatus(roomRequestDTO.getRoomStatus());
        room.setHotel(roomRequestDTO.getHotel());
        room.setRoomType(roomRequestDTO.getRoomType());
        roomRepository.save(room);
    }

    @Override
    public List<RoomRequestDTO> getAllRooms(){
        List<Room> rooms = roomRepository.findAll();

        return rooms.stream().map(room -> {
            RoomRequestDTO roomRequestDTO = new RoomRequestDTO();
            roomRequestDTO.setRoomNumber(room.getRoomNumber());
            roomRequestDTO.setRoomStatus(room.getRoomStatus());
            roomRequestDTO.setHotel(room.getHotel());
            roomRequestDTO.setRoomType(room.getRoomType());
            return roomRequestDTO;
        }).toList();
    }

    @Override
    public RoomRequestDTO getRoomById(Long id){
        Room room = roomRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Room Not Found"));
        RoomRequestDTO roomRequestDTO = new RoomRequestDTO();
        roomRequestDTO.setRoomNumber(room.getRoomNumber());
        roomRequestDTO.setRoomStatus(room.getRoomStatus());
        roomRequestDTO.setHotel(room.getHotel());
        roomRequestDTO.setRoomType(room.getRoomType());
        return roomRequestDTO;
    }

    @Override
    public RoomRequestDTO getRoomByRoomNumber(Long roomNumber){
        Room room = roomRepository.findByRoomNumber(roomNumber)
                .orElseThrow(()-> new EntityNotFoundException("Room Not Found"));
        RoomRequestDTO roomRequestDTO = new RoomRequestDTO();
        roomRequestDTO.setRoomNumber(room.getRoomNumber());
        roomRequestDTO.setRoomStatus(room.getRoomStatus());
        roomRequestDTO.setHotel(room.getHotel());
        roomRequestDTO.setRoomType(room.getRoomType());
        return roomRequestDTO;
    }

    @Override
    public RoomRequestDTO getRoomByHotel(Hotel hotel){
        Room room = roomRepository.findRoomByHotel(hotel)
                .orElseThrow(() -> new EntityNotFoundException("Room Not Found"));
        RoomRequestDTO roomRequestDTO = new RoomRequestDTO();
        roomRequestDTO.setRoomNumber(room.getRoomNumber());
        roomRequestDTO.setRoomStatus(room.getRoomStatus());
        roomRequestDTO.setHotel(room.getHotel());
        roomRequestDTO.setRoomType(room.getRoomType());
        return roomRequestDTO;
    }

    @Override
    public RoomRequestDTO getRoomByRoomType(RoomType roomType){
        Room room = roomRepository.findRoomByRoomType(roomType)
                .orElseThrow(()-> new EntityNotFoundException("Room Not Found"));
        RoomRequestDTO roomRequestDTO = new RoomRequestDTO();
        roomRequestDTO.setRoomNumber(room.getRoomNumber());
        roomRequestDTO.setRoomStatus(room.getRoomStatus());
        roomRequestDTO.setHotel(room.getHotel());
        roomRequestDTO.setRoomType(room.getRoomType());
        return roomRequestDTO;
    }

    @Override
    public RoomRequestDTO getRoomByRoomStatus(RoomStatus roomStatus){
        Room room = roomRepository.findRoomByRoomStatus(roomStatus)
                .orElseThrow(() -> new EntityNotFoundException("Room Not Found"));
        RoomRequestDTO roomRequestDTO = new RoomRequestDTO();
        roomRequestDTO.setRoomNumber(room.getRoomNumber());
        roomRequestDTO.setRoomStatus(room.getRoomStatus());
        roomRequestDTO.setHotel(room.getHotel());
        roomRequestDTO.setRoomType(room.getRoomType());
        return roomRequestDTO;
    }

    @Override
    public List<RoomResponseDTO> getAvailableRooms(LocalDateTime checkInTime, LocalDateTime checkOutTime){
        List<Room> rooms = roomRepository.findAvailableRooms(checkInTime,checkOutTime);
        if(rooms.isEmpty()){
            throw new EntityNotFoundException("Room Not Found");
        }

        return  rooms.stream().map(room ->{
            RoomResponseDTO roomResponseDTO = new RoomResponseDTO();
            roomResponseDTO.setRoomNumber(room.getRoomNumber());
            roomResponseDTO.setRoomStatus(room.getRoomStatus());
            roomResponseDTO.setHotel(room.getHotel());
            roomResponseDTO.setRoomType(room.getRoomType());
            return roomResponseDTO;
            
        }).toList();
    }
    
}
