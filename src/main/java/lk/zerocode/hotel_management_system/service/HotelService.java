package lk.zerocode.hotel_management_system.service;

import lk.zerocode.hotel_management_system.controller.request.HotelRequestDTO;
import lk.zerocode.hotel_management_system.controller.response.HotelResponseDTO;

import java.util.List;

public interface HotelService {
    void createHotel(HotelRequestDTO hotelRequestDTO);

    List<HotelRequestDTO> getAllHotels();

    HotelRequestDTO getHotelById(Long id);

    HotelRequestDTO getHotelByName(String hotelName);

    HotelResponseDTO updateHotel(Long id, HotelRequestDTO hotelRequestDTO);

    HotelResponseDTO deleteHotel(Long id);
}
