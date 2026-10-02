package com.lakshmikandan.primepass.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@JsonPropertyOrder({"id","movename","description","img","castIds","details","theaters" })
public class PrimepassModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String movename;
    String description;
    String img;
//    @ElementCollection
//            @CollectionTable(name="theaters",joinColumns = @JoinColumn(name="movie_id"))
//            @Column(name="theaters")
//            public List<String> theaterIds;
    String castIds;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="detail_id")
    public MovieDetailsModel details ;
    @JsonManagedReference
    @OneToMany(mappedBy ="primepassModel", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<TheatersModel> theaters;
}
