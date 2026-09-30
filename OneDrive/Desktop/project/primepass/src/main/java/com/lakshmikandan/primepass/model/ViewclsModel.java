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
public class ViewclsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int clsid;
    String clsName;
    int amount;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "shows_id")
    public ShowsModel showsModel;
    @JsonManagedReference
    @OneToMany(mappedBy = "viewcls", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public List<SeatsrowModel> seats;

}
