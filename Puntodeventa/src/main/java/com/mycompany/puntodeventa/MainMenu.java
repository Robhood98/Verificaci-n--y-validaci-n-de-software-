/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.puntodeventa;

import java.util.Scanner;

/**
 *
 * @author kaleb
 */
public class MainMenu {
     private final String PREFIX = "\n".repeat(25);
    
    private final String printMenu = """
                                               MENU         
                                     
                                     1) Empleados
                                     2) Provedores
                                     3) Catalogo
                                     4) Invetario
                                     5) Reportes
                                     
                                     
                                     X) Salir""";
    
    public void MainMenuLoop(){
        
        boolean salir = false;
        
        // Crear loop de eventos
        do{
            System.out.println(PREFIX + printMenu);
            System.out.print("\n\nSelecciona una opción: ");
            String seleccion = obtenerSeleccion();
            
            switch (seleccion) {
                case "1":
                    MenuEmpleados empleados = new MenuEmpleados();
                    empleados.MenuEmpleadosLoop();
//                    System.out.println("No se ha implementado el menu Empleados");
                    break;
                    
                case "2":
                    System.out.println("No se ha implementado el menu Provedores");
                    break;
                    
                case "3":
                    System.out.println("No se ha implementado el menu Catalogo");
                    break;
                    
                case "4":
                    System.out.println("No se ha implementado el menu Inventario");
                    break;
                    
                case "5":
                    System.out.println("No se ha implementado el menu Reportes");
                    break;
                    
                case "X":
                    salir = true;
                    
                default:
                    System.out.println("Selección no válida.");
            }
            
        } while(!salir);
    }
    
    private String obtenerSeleccion(){
        Scanner kb = new Scanner(System.in);
        
        return kb.nextLine();
    }
}

