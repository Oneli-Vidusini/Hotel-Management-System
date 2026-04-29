package lk.zerocode.hotel_management_system.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lk.zerocode.hotel_management_system.controller.request.HotelRequestDTO;
import lk.zerocode.hotel_management_system.controller.response.HotelResponseDTO;
import lk.zerocode.hotel_management_system.model.Hotel;
import lk.zerocode.hotel_management_system.repository.HotelRepository;
import lk.zerocode.hotel_management_system.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelSreviceImpl implements HotelService {
    private HotelRepository hotelRepository;

    @Override
    public void createHotel(HotelRequestDTO hotelRequestDTO){
        Hotel hotel = new Hotel();

        hotel.setHotelName(hotelRequestDTO.getHotelName());
        hotel.setLocation(hotelRequestDTO.getLocation());

        hotelRepository.save(hotel);
    }

    @Override
    public List<HotelRequestDTO> getAllHotels(){
        List<Hotel> hotels = hotelRepository.findAll();

        return hotels.stream().map(hotel -> {
            HotelRequestDTO hotelRequestDTO = new HotelRequestDTO();
            hotelRequestDTO.setHotelName(hotel.getHotelName());
            hotelRequestDTO.setLocation(hotel.getLocation());
            return hotelRequestDTO;
        }).toList();
    }

    @Override
    public HotelRequestDTO getHotelById(Long id){
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel id is invalid"));
        HotelRequestDTO hotelRequestDTO = new HotelRequestDTO();
        hotelRequestDTO.setHotelName(hotel.getHotelName());
        hotelRequestDTO.setLocation(hotel.getLocation());

        return hotelRequestDTO;
    }

    @Override
    public HotelRequestDTO getHotelByName(String hotelName){
        Hotel hotel = hotelRepository.findByHotelName(hotelName)
                .orElseThrow(() -> new EntityNotFoundException("Hotel name is invalid"));

        HotelRequestDTO hotelRequestDTO = new HotelRequestDTO();
        hotelRequestDTO.setHotelName(hotel.getHotelName());
        hotelRequestDTO.setLocation(hotel.getLocation());

        return hotelRequestDTO;
    }

    @Override
    public HotelResponseDTO updateHotel(Long id, HotelRequestDTO hotelRequestDTO){
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel id is invalid"));

        hotel.setHotelName(hotelRequestDTO.getHotelName());
        hotel.setLocation(hotelRequestDTO.getLocation());
        hotelRepository.save(hotel);

        HotelRequestDTO hotelRequestDto = new HotelRequestDTO();
        hotelRequestDto.setHotelName(hotel.getHotelName());
        hotelRequestDto.setLocation(hotel.getLocation());
        return new HotelResponseDTO();
    }

    @Override
    public HotelResponseDTO deleteHotel(Long id){
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Hotel id is invalid"));

        hotelRepository.deleteById(id);

        return null;

    }


}
