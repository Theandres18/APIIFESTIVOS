import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { OnInit } from '@angular/core';
interface Festivo {
  nombre: string;
  fecha: Date;
}

@Component({
  selector: 'app-servicio',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './servicio.component.html',
  styleUrl: './servicio.component.css'
})
export class ServicioComponent {
 year: number = new Date().getFullYear();
  festivos: Festivo[] = [];
  pagina: number = 1; // Para paginación futura

  constructor() {}

  ngOnInit(): void {
    // Al iniciar, se pueden cargar los festivos del año actual
    this.getFestivos();
  }

  getFestivos(): void {
    // Ejemplo estático; en un escenario real, reemplazar con un servicio HTTP
    const datos2023: Festivo[] = [
      { nombre: 'Año nuevo', fecha: new Date('2023-01-01') },
      { nombre: 'Santos Reyes', fecha: new Date('2023-01-09') },
      { nombre: 'San José', fecha: new Date('2023-03-20') },
      { nombre: 'Jueves Santo', fecha: new Date('2023-04-06') },
      { nombre: 'Viernes Santo', fecha: new Date('2023-04-07') },
      { nombre: 'Domingo de Pascua', fecha: new Date('2023-04-09') },
      { nombre: 'Día del Trabajo', fecha: new Date('2023-05-01') },
      { nombre: 'Ascensión del Señor', fecha: new Date('2023-05-22') },
      { nombre: 'Corpus Christi', fecha: new Date('2023-06-12') },
      { nombre: 'Sagrado Corazón de Jesús', fecha: new Date('2023-06-19') },
      { nombre: 'Sagrado Corazón de Jesús', fecha: new Date('2024-06-19') },
      // ... agregar los demás festivos del año
    ];

    if (this.year === 2023) {
      this.festivos = datos2023;
    } else {
      // Si se desea, limpiar o asignar arreglo vacío
      this.festivos = [];
    }

    // Para paginación simple se podría hacer algo así:
    this.pagina = 1;
  }
}

