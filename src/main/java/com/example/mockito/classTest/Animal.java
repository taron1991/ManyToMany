package com.example.mockito.classTest;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "animal")
@Entity
@Data
@NoArgsConstructor
class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "animal_owners", joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    public List<Owner> ownerList;


    public Animal(String name, List<Owner> ownerList) {
        this.name = name;
        this.ownerList = ownerList;
    }
}
