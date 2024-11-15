package com.example.festivos_api.repository;

import com.example.festivos_api.model.Festivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivoRepository extends JpaRepository<Festivo, Long> {
}
