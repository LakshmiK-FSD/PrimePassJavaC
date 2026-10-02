package com.lakshmikandan.primepass.service;

import com.lakshmikandan.primepass.model.*;
import com.lakshmikandan.primepass.repository.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PrimepassService {
    @Autowired
    private PrimepassRepository primepassRepo;
    @Autowired
    private TheatersRepository theatersRepo;
    @Autowired
    private DateRepository datRepo;
    @Autowired
    private ShowsRepository showsRepo;
    @Autowired
    private ViewclsRepository viewclsRepo;
    public List<PrimepassModel> getData() {
        List<PrimepassModel> hello=primepassRepo.findAll();
     return hello;
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
}
