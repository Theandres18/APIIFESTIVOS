import { Routes } from '@angular/router';
import { ServicioComponent } from './servicio/servicio.component';
export const routes: Routes = [

    { path: '', redirectTo: '/servicio', pathMatch: 'full' },
    { path: 'servicio', component: ServicioComponent },
];

