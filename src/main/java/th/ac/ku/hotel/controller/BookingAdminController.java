package th.ac.ku.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.hotel.models.Booking;
import th.ac.ku.hotel.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class BookingAdminController {
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAll(){
        return bookingService.getAll();
    }

}

