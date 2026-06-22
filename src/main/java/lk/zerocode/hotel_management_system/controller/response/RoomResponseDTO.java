package lk.zerocode.hotel_management_system.controller.response;

import lk.zerocode.hotel_management_system.model.Hotel;
import lk.zerocode.hotel_management_system.model.RoomType;
import lk.zerocode.hotel_management_system.model.enums.RoomStatus;
import lombok.Data;

@Data
public class RoomResponseDTO {
    private Long id;
    private Long roomNumber;
    private RoomStatus roomStatus;
    private Hotel hotel;
    private RoomType roomType;
}
