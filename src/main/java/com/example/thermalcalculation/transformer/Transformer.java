package com.example.thermalcalculation.transformer;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="transformers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transformer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "power")
    private int power;
    @Column(name = "pk")
    private int pk;
    @Column(name = "pxx")
    private int pxx;
    @Column(name = "x")
    private double x;
    @Column(name = "y")
    private double y;
    @Column(name = "tau")
    private int tau;
    @Column(name = "vm")
    private int vm;
    @Column(name = "vnnt")
    private int vnnt;
}
