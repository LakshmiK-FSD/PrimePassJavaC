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
public class DateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int dateId;
    String date;
    @JsonManagedReference
    @OneToMany(mappedBy ="dates", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public List<ShowsModel> shows;
    @JsonBackReference
    @ManyToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="theaters_id")
    public TheatersModel theatersModel;
}
