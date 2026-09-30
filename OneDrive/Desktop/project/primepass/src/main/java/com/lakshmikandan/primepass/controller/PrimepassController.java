package com.lakshmikandan.primepass.controller;

import com.lakshmikandan.primepass.model.PrimepassModel;
import com.lakshmikandan.primepass.model.TheatersModel;
import com.lakshmikandan.primepass.service.PrimepassService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@CrossOrigin("http://localhost:5173")
public class PrimepassController {
    @Autowired
    private PrimepassService primepass;
   @GetMapping("/movies")
    public List<PrimepassModel> movies(){
        return primepass.getData();
    }
    @GetMapping("/movies/{id}")
    public PrimepassModel idMovie(@PathVariable int id){
        return primepass.idMovie(id);
    }
    @GetMapping("/{theatid}")
    public TheatersModel theatersModel(@PathVariable("theatid") int theatid){
       return primepass.theater(theatid);
    }
    @PostMapping("/movies")
    public String adder(@RequestBody PrimepassModel prm){
       return primepass.adder(prm);
    }
}
