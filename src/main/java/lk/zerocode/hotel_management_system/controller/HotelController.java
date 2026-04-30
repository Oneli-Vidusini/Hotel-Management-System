package lk.zerocode.hotel_management_system.controller;

import lk.zerocode.hotel_management_system.controller.request.HotelRequestDTO;
import lk.zerocode.hotel_management_system.controller.response.HotelResponseDTO;
import lk.zerocode.hotel_management_system.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class HotelController {
    private HotelService hotelService;

    @PostMapping(value = "/hotels")
    public void createHotel(@RequestBody HotelRequestDTO hotelRequestDTO){
        hotelService.createHotel(hotelRequestDTO);
    }
    @GetMapping(value = "/hotels")
    public List<HotelRequestDTO> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping(value = "/{id}/hotels")
    public HotelRequestDTO getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }

    @GetMapping(value = "/{hotelName}/name/hotels")
    public HotelRequestDTO getHotelByHotelName(@PathVariable String hotelName){
        return hotelService.getHotelByName(hotelName);
    }

    @PutMapping(value = "/{id}/hotels")
    public HotelResponseDTO updateHotel(@PathVariable Long id, @RequestBody HotelRequestDTO hotelRequestDTO){
        return hotelService.updateHotel(id, hotelRequestDTO);
    }

    @DeleteMapping(value = "/{id}/hotels")
    public HotelResponseDTO deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);
        return null;
    }
}
