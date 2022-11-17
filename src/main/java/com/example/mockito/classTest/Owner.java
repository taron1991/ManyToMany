package com.example.mockito.classTest;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "owner")
@Entity
@Data
@NoArgsConstructor
class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "animal_owners", joinColumns = @JoinColumn( name= "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_id"))
    public List<Animal> animal = new ArrayList<>();


}