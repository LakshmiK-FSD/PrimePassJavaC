package com.lakshmikandan.primepass.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@JsonPropertyOrder({"theatid","theaterName","cancelation","theaterAddress","dates"})
public class TheatersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int theatid;
    String theaterName;
    String cancelation;
    @ElementCollection @CollectionTable(name = "address",joinColumns = @JoinColumn(name = "theaters_id"))
            @Column(name = "location")
    public Set<String> theaterAddress;
    @JsonManagedReference
    @OneToMany(mappedBy ="theatersModel", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public List<DateModel> dates;

    @JsonBackReference
    @ManyToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="primepass_id")
    public PrimepassModel primepassModel;

}
