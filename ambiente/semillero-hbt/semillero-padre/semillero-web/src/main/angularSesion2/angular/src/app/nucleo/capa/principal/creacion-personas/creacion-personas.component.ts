import { Component, OnInit } from '@angular/core';
import { personaModel } from "./modelos/persona.model";

/**
 * @author felipe jamioy
 */
@Component({
  selector: 'app-creacion-personas',
  templateUrl: './creacion-personas.component.html'
})
export class CreacionPersonasComponent implements OnInit {
  
  persona: personaModel; //declaracion modelo
  personas: personaModel[]; //arreglo del modelo
  public mostrarFormulario:boolean;
  public mostrarTabla:boolean; //bandera para poder mostrar la tabla
  public mostrarCrearUsuario:boolean; //bandera para poder mostrar la creacion de usuarios
  public mostrarEdicionUsuario:boolean;//bandera para mostrar la edicion
  title:string; //titulo para cambiar segun la vista

  tipoId = [] //arreglo para cargar los tipos de identificacion
  estado = [] //arrreglo para cargar los estados
  sexo = [] //arreglo para cargar el sexo
  
  /**
   * constructor
   */
  constructor() { }

  /**
   * ngOnInit
   */

  ngOnInit() {
    //inicializaion de la persona
    this.persona = {
      id: '0', 
      tipoIdentificacion:'', 
      nombre: '',
      apellidos: '', 
      telefono: '', 
      estado: '', 
      rol: '', 
      edad:'',
      nacimiento:new Date,
      numeroIdentificacion: '', 
      mayorEdad: false, 
      sexo: '',     
    };
    //inicializacion de los arreglos
    this.personas=[]
    this.tipoId = ["cedula", "cedula extranjera", "pasaporte", "tarjeta de identidad"]
    this.estado= ["Casado", "Soltero", "Separado", "Divorciado"]
    this.sexo = ["Masculino", "Femenino"]
    //inicialiacion de las banderas
    this.mostrarTabla = false;
    this.mostrarCrearUsuario = true;
    this.mostrarCrearUsuario=false;  

  }

  /**
   * metodo que guaarda una personas
   */
  public guardar(){
    this.personas.push(this.persona)
    console.log('guardar()' + this.persona.nombre)
  }

  /**
   * metodo que edita una persona
   */
  public editar(){
    this.personas.push(this.persona)
  }

  /**
   * metodo para cambiar la bandera y mostrar la tabla
   */
  mostrarTabl(){
    this.mostrarTabla = true;
    this.mostrarCrearUsuario =false;
    this.mostrarEdicionUsuario = false;
    this.title="Gestionar usuario"

  }

   /**
   * metodo para cambiar la bandera y mostrar la creacion
   */
  mostrarCrear(){
    this.mostrarTabla = false;
    this.mostrarCrearUsuario =true;
    this.mostrarEdicionUsuario = false;
    this.title="Crear Usuario"
  }

   /**
   * metodo para cambiar la bandera y mostrar la vista edicion
   */
  mostrarEdicion(){
    this.mostrarTabla = false;
    this.mostrarCrearUsuario =false;
    this.mostrarEdicionUsuario = true;
    this.title="Editar Usuario"

  }



}
