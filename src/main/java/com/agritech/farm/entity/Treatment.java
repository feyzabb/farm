package com.agritech.farm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "treatments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String treatmentType;

    @Column(nullable = false)
    private LocalDate treatmentDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agronomist_id", nullable = false)
    private Agronomist agronomist;
}