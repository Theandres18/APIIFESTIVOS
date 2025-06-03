package com.andres.api_festivos.service;

import com.andres.api_festivos.model.Festivo;
import com.andres.api_festivos.repository.FestivoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FestivoService {

    @Autowired
    private FestivoRepository repo;

    @PostConstruct
    public void initData() {
        if (repo.count() == 0) {
            repo.save(new Festivo("Año nuevo", LocalDate.of(2023, 1, 1)));
            repo.save(new Festivo("Santos Reyes", LocalDate.of(2023, 1, 9)));
            // ... agrega más festivos
        }
    }

    public List<Festivo> listarPorAnio(int year) {
        // Usa el método JPQL si tu versión de Spring Data no resuelve automáticamente findByFechaYear
        return repo.findFestivosPorAnio(year);
        // Si tu Spring Data JPA está en una versión que sí soporta findByFechaYear, 
        // podrías invocar: return repo.findByFechaYear(year);
    }

    public boolean esFestivo(LocalDate fecha) {
        return repo.existsByFecha(fecha);
    }
}