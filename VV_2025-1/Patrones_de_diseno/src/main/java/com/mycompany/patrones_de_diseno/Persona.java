/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patrones_de_diseno;

/**
 *
 * @author chris
 */
public class Persona {

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String ocupacion;
    private String edad;
    
    public Persona(
        String nombre,
        String apellido, 
        String correo,
        String telefono, 
        String ocupacion, 
        String edad
    ){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
        this.edad = edad;
    }
    
   
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", telefono=" + telefono + ", ocupacion=" + ocupacion + ", edad=" + edad + '}';
    }
}