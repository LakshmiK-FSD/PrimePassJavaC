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
public class ShowsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int timeId;
    String time;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "dates_id")
    public DateModel dates;
    @JsonManagedReference
    @OneToMany(mappedBy = "showsModel", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<ViewclsModel> viewcls;


}
