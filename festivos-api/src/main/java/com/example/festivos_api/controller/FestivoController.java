package com.example.festivos_api.controller;

import com.example.festivos_api.FechaService;
import com.example.festivos_api.model.Festivo;
import com.example.festivos_api.repository.FestivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/festivos")
public class FestivoController {

    @Autowired
    private FechaService fechaService;

    @Autowired
    private FestivoRepository festivoRepository;

    @GetMapping("/festivos")
    public ResponseEntity<List<Festivo>> getFestivos() {
    return ResponseEntity.ok(festivoRepository.findAll());
    }

    @GetMapping("/esFestivo")
public ResponseEntity<String> esFestivo(@RequestParam int dia, @RequestParam int mes, @RequestParam int year) {
    try {
        // Intentamos crear la fecha con los parámetros proporcionados
        LocalDate fecha = LocalDate.of(year, mes, dia);
        
        List<Festivo> festivos = festivoRepository.findAll();

        // Verificamos si la fecha es festiva
        if (fechaService.esFestivo(fecha, festivos)) {
            return ResponseEntity.ok("La fecha es festiva.");
        } else {
            return ResponseEntity.ok("La fecha no es festiva.");
        }
    } catch (DateTimeException e) {
        // Si la fecha es inválida, retornamos un mensaje de error
        return ResponseEntity.badRequest().body("Fecha inválida.");
    }
}
}

