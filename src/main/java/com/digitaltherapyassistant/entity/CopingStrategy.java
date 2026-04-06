package com.digitaltherapyassistant.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "coping_strategy")
@Data
@NoArgsConstructor
public class CopingStrategy {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;

    @Column(name = "name")
    private String name ;

    @Column(name = "description")
    private String description ;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "cognitive_distortion_examples", joinColumns = @JoinColumn(name = "cognitive_distortion_id"))
    @Column(name = "steps")
    private List<String> steps ;
}
