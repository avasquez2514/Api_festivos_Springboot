package com.example.festivos_api;

import com.example.festivos_api.model.Festivo;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class FechaService {

    public LocalDate calcularDomingoPascua(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        int dias = d + e;

        return LocalDate.of(year, 3, 15).plusDays(dias + 7); // Domingo de Pascua es una semana después
    }

public boolean esFestivo(LocalDate fecha, List<Festivo> festivos) {
    int year = fecha.getYear();
    LocalDate pascua = calcularDomingoPascua(year);

    for (Festivo festivo : festivos) {
        LocalDate fechaFestivo;

        switch (festivo.getTipo()) {
            case 1: // Fijo
                fechaFestivo = LocalDate.of(year, festivo.getMes(), festivo.getDia());
                break;
            case 2: // Ley de Puente Festivo
                fechaFestivo = LocalDate.of(year, festivo.getMes(), festivo.getDia());
                // Trasladar al lunes si cae en sábado o domingo
                if (fechaFestivo.getDayOfWeek() == DayOfWeek.SATURDAY) {
                    fechaFestivo = fechaFestivo.plusDays(2);
                } else if (fechaFestivo.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    fechaFestivo = fechaFestivo.plusDays(1);
                }
                break;
            case 3: // Basado en Pascua
                fechaFestivo = pascua.plusDays(festivo.getDiasDesdePascua());
                break;
            case 4: // Basado en Pascua y Ley de Puente Festivo
                fechaFestivo = pascua.plusDays(festivo.getDiasDesdePascua());
                if (fechaFestivo.getDayOfWeek() == DayOfWeek.SATURDAY) {
                    fechaFestivo = fechaFestivo.plusDays(2);
                } else if (fechaFestivo.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    fechaFestivo = fechaFestivo.plusDays(1);
                }
                break;
            default:
                throw new IllegalArgumentException("Tipo de festivo desconocido: " + festivo.getTipo());
        }

        if (fecha.equals(fechaFestivo)) {
            return true;
        }
    }
    return false;
}

}

