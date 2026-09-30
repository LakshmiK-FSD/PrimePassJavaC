package com.lakshmikandan.primepass.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class SeatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int setid;
    String seatId;
    int number;
    String rowId;
    String status;
    String bookedBy;
    String bookingTime;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="seatrow_id")
    public SeatsrowModel seatsrow;

}
