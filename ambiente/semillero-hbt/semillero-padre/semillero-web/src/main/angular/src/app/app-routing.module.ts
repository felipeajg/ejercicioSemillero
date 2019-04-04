import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EncabezadoComponent } from './nucleo/capa/encabezado/encabezado.component';
import { MainComponent } from './nucleo/capa/main/main.component';
import { PiepaginaComponent } from './nucleo/capa/piepagina/piepagina.component';
import { CreacionPersonaComponent } from './nucleo/capa/main/creacion-persona/creacion-persona.component';

export const routes: Routes = [
  { path: 'nucleo', loadChildren: './nucleo/nucleo.module#NucleoModule'},
  { path: 'encabezado', component: EncabezadoComponent },
    { path: 'main', component: MainComponent },
    { path: 'piepagina', component: PiepaginaComponent },
    { path: 'persona', component: CreacionPersonaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
