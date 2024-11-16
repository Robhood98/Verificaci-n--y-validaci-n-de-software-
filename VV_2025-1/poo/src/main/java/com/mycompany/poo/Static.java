

package com.mycompany.poo;

/**
 *
 * @author chris
 */
public class Static {
    
    static int cont;
    
    public Static(){
        cont++;
    }
    
    public static void funcionEstatica(){
        System.out.println("Funcion estática");
    }
    
    public void funcionNoEstatica(){
        System.out.println("Función no estática");
    }
}