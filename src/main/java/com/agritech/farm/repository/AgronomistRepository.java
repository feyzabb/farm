package com.agritech.farm.repository;

import com.agritech.farm.entity.Agronomist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgronomistRepository extends JpaRepository<Agronomist, Long> {
}