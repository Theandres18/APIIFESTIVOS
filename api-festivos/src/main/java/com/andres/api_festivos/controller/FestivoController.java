package com.andres.api_festivos.controller;

import com.andres.api_festivos.model.Festivo;
import com.andres.api_festivos.service.FestivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/festivos")
@CrossOrigin(origins = "http://localhost:4200")
public class FestivoController {

    @Autowired
    private FestivoService service;

    @GetMapping("/{year}")
    public ResponseEntity<List<Festivo>> getFestivosPorAnio(@PathVariable int year) {
        List<Festivo> lista = service.listarPorAnio(year);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/esFestivo")
    public ResponseEntity<Boolean> esFestivo(
        @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) 
    {
        boolean resp = service.esFestivo(fecha);
        return ResponseEntity.ok(resp);
    }
}
