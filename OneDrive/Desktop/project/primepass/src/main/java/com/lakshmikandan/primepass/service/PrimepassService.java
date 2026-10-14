package com.lakshmikandan.primepass.service;

import com.lakshmikandan.primepass.model.*;
import com.lakshmikandan.primepass.repository.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
@Data
public class PrimepassService {
    @Autowired
    private PrimepassRepository primepassRepo;
    @Autowired
    private TheatersRepository theatersRepo;
    @Autowired
    private SeatRepository seatRepo;
    @Autowired
    private DateRepository datRepo;
    @Autowired
    private ShowsRepository showsRepo;
    @Autowired
    private ViewclsRepository viewclsRepo;
    public List<PrimepassModel> getData() {
        List<PrimepassModel> primeModel=primepassRepo.findAll();
     return primeModel;
    }
    public TheatersModel theater(int theatid) {
       return theatersRepo.findById(theatid).orElse(null);
    }
    public PrimepassModel idMovie(int id) {
        return primepassRepo.findById(id).orElse(null);
    }
    public String adder(PrimepassModel prm) {
        primepassRepo.save(prm);
        return "added";
    }
    public List<String> findDates() {
        return datRepo.findByDistinctDates();
    }
    public DateModel dateModel(int date) {
        return datRepo.findById(date).orElse(null);
    }
    public ShowsModel timeModel(int tmId) {
        return showsRepo.findById(tmId).orElse(null);
    }
    public ViewclsModel viewcls(int clsId) {
        return viewclsRepo.findById(clsId).orElse(null);
    }
    public List<PrimepassModel> search(String search) {
        return primepassRepo.findBySearch(search);
    }

    public ResponseEntity<?> booking(Map<String,List<String>> bkModel) {
            List<String> book = bkModel.get("seats");
            List<String> booker = bkModel.get("booker");
            String bookedBy = booker.get(0);
            for(String seats: book){
                int seatId = Integer.parseInt(seats);
                 SeatModel seatModel = seatRepo.findById(seatId).orElse(null);
                if(seatModel != null && bookedBy != null) {
                    LocalDateTime now = LocalDateTime.now();
                    seatModel.setBookingTime(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                    seatModel.setStatus("BOOKED");
                    seatModel.setBookedBy(bookedBy);
                    seatRepo.save(seatModel);
                }
            };
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Map.of("value","ok"));
    }
}
