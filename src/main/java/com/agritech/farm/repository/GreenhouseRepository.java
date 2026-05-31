package com.agritech.farm.repository;

import com.agritech.farm.entity.Greenhouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreenhouseRepository extends JpaRepository<Greenhouse, Long> {
}