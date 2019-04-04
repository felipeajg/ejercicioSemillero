import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-creacion-persona',
  templateUrl: './creacion-persona.component.html',
  styleUrls: ['./creacion-persona.component.css']
})
export class CreacionPersonaComponent implements OnInit {

  public id:String = "1";
  public numeroId : String = "1094930794"
  public nombre:String = "felipe";
  public apellido: String = "Jamioy"
  public tipoId = ["cedula", "tarjeta de identidad", "pasaporte"];

  constructor() { }

  ngOnInit() {
  }

}
