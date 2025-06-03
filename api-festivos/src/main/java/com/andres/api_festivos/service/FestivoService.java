package com.andres.api_festivos.service;

import com.andres.api_festivos.model.Festivo;
import com.andres.api_festivos.repository.FestivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
            // ... agrega más festivos según necesites
        }
    }

    public List<Festivo> listarPorAnio(int year) {
        // Si tienes el método findByFechaYear disponible:
        return repo.findByFechaYear(year);
        // Si usas findFestivosPorAnio, reemplaza la línea anterior por:
        // return repo.findFestivosPorAnio(year);
    }

    public boolean esFestivo(LocalDate fecha) {
        return repo.existsByFecha(fecha);
    }
}
