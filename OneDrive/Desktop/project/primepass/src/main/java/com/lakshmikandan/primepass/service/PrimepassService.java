package com.lakshmikandan.primepass.service;

import com.lakshmikandan.primepass.model.PrimepassModel;
import com.lakshmikandan.primepass.model.TheatersModel;
import com.lakshmikandan.primepass.repository.PrimepassRepository;
import com.lakshmikandan.primepass.repository.TheatersRepository;
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
}
