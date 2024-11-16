/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.puntodeventa.newpackage;

import org.junit.Test;
import static org.junit.Assert.*;



public class UsuarioTest {
    
    public UsuarioTest() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Usuario instance = new Usuario(9, "Pedro", "jvalenzuela@ucgdl.edu.mx","Valenzuela", "admin");
        int expResult = 9;
        int result = instance.getId();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 100;
        Usuario instance = new Usuario(9, "Pedro", "jvalenzuela@ucgdl.edu.mx","Valenzuela", "admin");
        instance.setId(id);
        int result = instance.getId();
        
        assertEquals(id, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Usuario instance = new Usuario(9, "Pedro", "jvalenzuela@ucgdl.edu.mx","Valenzuela", "admin");
        String expResult = "Pedro";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Juan";
        Usuario instance = new Usuario(9, "Pedro", "jvalenzuela@ucgdl.edu.mx","Valenzuela", "admin");
        instance.setNombre(nombre);
        
        String result = instance.getNombre();
        
        assertEquals(nombre, result);
    }

    @Test
    public void testGetCorreo() {
        System.out.println("getCorreo");
        Usuario instance = new Usuario(9, "Pedro", "jvalenzuela@ucgdl.edu.mx","Valenzuela", "admin");
        String expResult = "jvalenzuela@ucgdl.edu.mx";
        String result = instance.getCorreo();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetCorreo() {
        System.out.println("setCorreo");
        String correo = "nuevo@correo.com";
        Usuario instance = new Usuario(9, "Pedro", "jvalenzuela@ucgdl.edu.mx","Valenzuela", "admin");
        instance.setCorreo(correo);
        
        String result = instance.getCorreo();
        assertEquals(correo, result);
    }

    @Test
    public void testGetContra() {
        System.out.println("getContra");
        Usuario instance = new Usuario(9, "Pedro", "jvalenzuela@ucgdl.edu.mx","Valenzuela", "admin");
        String expResult = "Valenzuela";
        String result = instance.getContra();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetContra() {
        System.out.println("setContra");
        String contra = "12345";
        Usuario instance = new Usuario(9, "Pedro", "jvalenzuela@ucgdl.edu.mx","Valenzuela", "admin");
        instance.setContra(contra);
        
        String result = instance.getContra();
        assertEquals(contra, result);
    }

    @Test
    public void testGetRol() {
        System.out.println("getRol");
        Usuario instance = new Usuario(9, "Pedro", "jvalenzuela@ucgdl.edu.mx","Valenzuela", "admin");
        String expResult = "admin";
        String result = instance.getRol();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetRol() {
        System.out.println("setRol");
        String rol = "boss";
        Usuario instance = new Usuario(9, "Pedro", "jvalenzuela@ucgdl.edu.mx","Valenzuela", "admin");
        instance.setRol(rol);
        
        String result = instance.getRol();
        assertEquals(rol, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Usuario instance = new Usuario(9, "Pedro", "jvalenzuela@ucgdl.edu.mx","Valenzuela", "admin");
        String expResult = "Usuario{id=9, nombre=Pedro, correo=jvalenzuela@ucgdl.edu.mx, contra=Valenzuela, rol=admin}";
        String result = instance.toString();
        
        System.out.println(result);
        
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
