package com.andres.api_festivos.repository;

import com.andres.api_festivos.model.Festivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FestivoRepository extends JpaRepository<Festivo, Long> {
    // Si tu versión de Spring Data soporta findByFechaYear:
    List<Festivo> findByFechaYear(int year);

    // Alternativa con JPQL si no soporta directamente el método anterior:
    @Query("SELECT f FROM Festivo f WHERE FUNCTION('YEAR', f.fecha) = :year")
    List<Festivo> findFestivosPorAnio(@Param("year") int year);

    boolean existsByFecha(LocalDate fecha);
}
