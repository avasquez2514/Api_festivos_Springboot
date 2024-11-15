package com.example.festivos_api.repository;

import com.example.festivos_api.model.TipoFestivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoFestivoRepository extends JpaRepository<TipoFestivo, Long> {
}