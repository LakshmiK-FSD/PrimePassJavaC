package com.lakshmikandan.primepass.controller;

import com.lakshmikandan.primepass.model.*;
import com.lakshmikandan.primepass.service.PrimepassService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/users")
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
    @GetMapping("/theater/{theatid}")
    public TheatersModel theatersModel(@PathVariable("theatid") int theatid){
       return primepass.theater(theatid);
    }
    @PostMapping("/movies")
    public String adder(@RequestBody PrimepassModel prm){
       return primepass.adder(prm);
    }
    @GetMapping("/theatdate")
    public List<String> findDates(){
       return primepass.findDates();
    }
    @GetMapping("/dates/{date}")
    public DateModel dateModel(@PathVariable int date){
       return primepass.dateModel(date);
    }
    @GetMapping("/time/{timeId}")
    public ShowsModel timeModel(@PathVariable("timeId") int tmId){
       return primepass.timeModel(tmId);
    }
    @GetMapping("/viewclass/{clsId}")
    public ViewclsModel viewcls(@PathVariable int clsId){
       return primepass.viewcls(clsId);
    }

}
