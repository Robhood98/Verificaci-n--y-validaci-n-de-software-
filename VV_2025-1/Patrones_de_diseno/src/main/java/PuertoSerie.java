/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patrones_de_diseno;

/**
 *
 * @author chris
 */

public class PuertoSerie {
    
    private static PuertoSerie instancia;
    
    private PuertoSerie(){
        System.out.println("Constructor de PuertoSerie");
    }
    
    public static PuertoSerie obtenerInstancia(){
        if(instancia == null){
            instancia = new PuertoSerie();
        }
        
        return instancia;
    }
}