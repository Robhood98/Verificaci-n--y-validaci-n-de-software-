
package com.mycompany.poo;

/**
 *
 * @author chris
 */
import mx.com.vafis.polimorfismo.Estudiante;
import mx.com.vafis.polimorfismo.Profesor;
import patrones_de_diseno.Builder.ConstructorPersona;
import patrones_de_diseno.Builder.Persona;
import patrones_de_diseno.PuertoSerie;
import patrones_de_diseno.decorator.Decorator;
import patrones_de_diseno.decorator.Primo;
import patrones_de_diseno.decorator.PrimoOptimizado;
import patrones_de_diseno.decorator.Tarea;
import patrones_de_diseno.observer.Manager;
import patrones_de_diseno.observer.Usuario;
import patrones_de_diseno.observer.Suscriptor;

public class POO {

    public static void main(String[] args) {
        
        Manager manager = new Manager();
        
        Suscriptor usuario1 = new Usuario("Ana");
        Suscriptor usuario2 = new Usuario("Juan");
        
        manager.agregarSuscriptor(usuario1);
        manager.agregarSuscriptor(usuario2);
        
        manager.publicarNewsletter("Primera newsletter");
        
        Suscriptor usuario3 = new Usuario("Pedro");
        manager.agregarSuscriptor(usuario3);
        
        manager.publicarNewsletter("Segunda newsletter");
        
        manager.eliminarSuscriptor(usuario2);
        
        manager.publicarNewsletter("Ultima newsletter");
        
        System.exit(0);
        
//        Tarea t1 = new Tarea1();
//        Decorator d1 = new Decorator(t1);
//        d1.ejecutar();
//        
//        Tarea t2 = new Tarea2();
//        Decorator d2 = new Decorator(t2);
//        d2.ejecutar();
//        
//        Tarea t3 = new Tarea3();
//        Decorator d3 = new Decorator(t3);
//        d3.ejecutar();
//        
//        Tarea t4 = new Tarea4();
//        Decorator d4 = new Decorator(t4);
//        d4.ejecutar();
       
        Tarea t1 = new Primo(999983); // 29989 999983
        Decorator d1 = new Decorator(t1);
        d1.ejecutar();
        
        Tarea t2 = new PrimoOptimizado(999983); // 29989 999983
        Decorator d2 = new Decorator(t2);
        d2.ejecutar();
        
        System.exit(0);
        
        ConstructorPersona cp = new ConstructorPersona();
        cp.setNombre("Pedro");
        cp.setApellido("Valenzuela");
        cp.setOcupacion("Profesor");
        
        Persona persona = cp.construir();
        
        System.out.println(persona);
        
        System.exit(0);
        
        PuertoSerie ps1 = PuertoSerie.obtenerInstancia();
        //PuertoSerie ps2 = new PuertoSerie();
        PuertoSerie ps2 = PuertoSerie.obtenerInstancia();
        PuertoSerie ps3 = PuertoSerie.obtenerInstancia();
        
        System.out.println(ps1);
        System.out.println(ps2);
        System.out.println(ps3);
        
        System.exit(0);
        
        Static.funcionEstatica();
        
        Static s = new Static();
        s.funcionNoEstatica();
        
        
        Static s2 = new Static();
        Static s3 = new Static();
        Static s4 = new Static();
        Static s5 = new Static();
        
        System.exit(0);
        
        test();        
        
        Estudiante e1 = new Estudiante("Pedro");
        Estudiante e2 = new Estudiante("Juan", "jvalenzuela@ucgdl.edu.mx");
        Estudiante e3 = new Estudiante("Jose", "jose@correo.com", 2);
        
        Profesor p0 = new Profesor();
        //Profesor p1 = new Profesor("Pedro");
        Profesor p2 = new Profesor("Juan", "jvalenzuela@ucgdl.edu.mx");
        //Profesor p3 = new Profesor("Jose", "jose@correo.com", 2);
        Profesor p4 = new Profesor("Jose", "jose@correo.com", "12345", 2);
       // p4.id = 9;
        
        System.exit(0);
        
        Profesor profesor = new Profesor("Pedro Valenzuela", "jvalenzuela@ucgdl.edu.mx");
        System.out.println(profesor);
        //profesor.presentacion();
        
        Estudiante estudiante1 = new Estudiante("Jose", "jose@mail.com");
        System.out.println(estudiante1);
        //estudiante1.presentacion();
        
        Estudiante estudiante2 = new Estudiante("", "maria@mail.com");
        System.out.println(estudiante2);
        
        Estudiante estudiante3 = new Estudiante("Juan", "juan@mail.com");
        System.out.println(estudiante3);
    }


    public static void test(){
        System.err.println("Prueba!");
    }
}