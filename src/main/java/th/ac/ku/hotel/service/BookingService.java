package th.ac.ku.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.hotel.models.Booking;
import th.ac.ku.hotel.repository.BookingRepository;

import java.util.List;
import java.util.UUID;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAll(){
        return bookingRepository.findAll();
    }

    public Booking getBooking(UUID id){
        return bookingRepository.findById(id).get();
    }

    public Booking create(Booking booking){
        bookingRepository.save(booking);
        return booking;
    }

    public Booking update(UUID id, Booking requestBody){
        Booking record = bookingRepository.findById(id).get();
        if (requestBody.getFirstName() != null){
            record.setFirstName(requestBody.getFirstName());
        }
        if (requestBody.getLastName() != null){
            record.setLastName(requestBody.getLastName());
        }
        if (requestBody.getEmail() != null){
            record.setEmail(requestBody.getEmail());
        }
        if (requestBody.getPhone() != null){
            record.setPhone(requestBody.getPhone());
        }
        if (requestBody.getHotelName() != null){
            record.setHotelName(requestBody.getHotelName());
        }
        if (requestBody.getRoomType() != null){
            record.setRoomType(requestBody.getRoomType());
        }
        if (requestBody.getNumRoom() > 0){
            record.setNumRoom(requestBody.getNumRoom());
        }
        if (requestBody.getCheckin() != null){
            record.setCheckin(requestBody.getCheckin());
        }
        if (requestBody.getCheckout() != null){
            record.setCheckout(requestBody.getCheckout());
        }
        if (requestBody.getPrice() > 0){
            record.setPrice(requestBody.getPrice());
        }
        if (requestBody.getStatus() == "Pending"){      //ถ้าลูกค้ากดจอง+กรอกหลักฐานการจ่ายเงิน
            requestBody.setStatus("Paid");              //เปลี่ยนสถานะเป็น จ่ายเงินแล้ว
            record.setStatus(requestBody.getStatus());
        }
//        else if (requestBody.getStatus() == "Paid"){    //ถ้าแอดมินเข้ามากดยืนยันการจองให้
//            requestBody.setStatus("Completed");         //เปลี่ยนสถานะเป็น จองสำเร็จ
//            record.setStatus(requestBody.getStatus());
//        }

        Booking b = bookingRepository.save(record);

        return b;
    }
}
