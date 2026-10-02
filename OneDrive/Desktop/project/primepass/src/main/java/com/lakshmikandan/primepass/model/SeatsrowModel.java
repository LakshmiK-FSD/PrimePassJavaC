package com.lakshmikandan.primepass.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class SeatsrowModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int seatrid;
    String rowname;
    @JsonManagedReference
    @OneToMany(mappedBy = "seatsrow", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<SeatModel> clrow;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "viewcls_id")
    public ViewclsModel viewcls;
}
