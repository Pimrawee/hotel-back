package th.ac.ku.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.hotel.models.Booking;
import th.ac.ku.hotel.service.BookingService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAll(){
        return bookingService.getAll();
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking){
        return bookingService.create(booking);
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable UUID id){
        return bookingService.getBooking(id);
    }

    @PutMapping("/{id}")
    public Booking update(@PathVariable UUID id, @RequestBody Booking booking){
        return bookingService.update(id, booking);
    }
}
