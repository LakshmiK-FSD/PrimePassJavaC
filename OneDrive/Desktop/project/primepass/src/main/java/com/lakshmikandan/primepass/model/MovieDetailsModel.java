package com.lakshmikandan.primepass.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonPropertyOrder({"id","title","rating","language","duration","view","summary","genres","releaseDate" })
public class MovieDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String rating;
    String language;
    String duration;
    String view;
    String summary;
    String genres;
    String releaseDate;
    @JsonBackReference
    @OneToOne(mappedBy = "details",fetch = FetchType.LAZY)
    public PrimepassModel primepass;

}
