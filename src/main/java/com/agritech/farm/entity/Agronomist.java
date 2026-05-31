package com.agritech.farm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "agronomists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agronomist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String specialization;

    @OneToMany(mappedBy = "agronomist", cascade = CascadeType.ALL)
    private List<Treatment> treatments;
}