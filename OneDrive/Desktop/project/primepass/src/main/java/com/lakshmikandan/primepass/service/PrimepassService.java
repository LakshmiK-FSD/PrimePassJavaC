package com.lakshmikandan.primepass.service;

import com.lakshmikandan.primepass.model.*;
import com.lakshmikandan.primepass.repository.*;
import com.lakshmikandan.primepass.security.JwtUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UsersRepository usersRepo;
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

    public List<SeatModel> prizeSeats(List<String> seats) {
        List<SeatModel> seatsFn = new ArrayList<>();
        for(String e: seats) {
            int id =Integer.parseInt(e);
            SeatModel finded = seatRepo.findById(id).get();
            seatsFn.add(finded);
        }
        return seatsFn;
    }

    public List<SeatModel> myPasses(String bearer) {
        String token = bearer.substring(7);
        String email =jwtUtil.unWrap(token);
        Optional<UsersModel> option = usersRepo.findByEmail(email);
        UsersModel user = option.get();
        int id = user.getId();
        List<SeatModel> seatsBooked = seatRepo.findByBookedBy(id);
        return seatsBooked;
    }
}
