
package com.mycompany.puntodeventa;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Usuario instance = new Usuario(9,"robin","villasenor","","");
        int expResult = 9;
        int result = instance.getId();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 100;
        Usuario instance = new Usuario(9,"robin","villasenor","","");
        instance.setId(id);
        int result = instance.getId();
                
        assertEquals(id, result);

        //fail("The test case is a prototype.");
        
           }
    
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        String nombre = "robin";
        Usuario instance = new Usuario(9,"robin","villasenor","","");
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Usuario instance = null;
        instance.setNombre(nombre);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCorreo() {
        System.out.println("getCorreo");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getCorreo();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetCorreo() {
        System.out.println("setCorreo");
        String correo = "";
        Usuario instance = null;
        instance.setCorreo(correo);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetContra() {
        System.out.println("getContra");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getContra();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetContra() {
        System.out.println("setContra");
        String contra = "";
        Usuario instance = null;
        instance.setContra(contra);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetRol() {
        System.out.println("getRol");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getRol();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetRol() {
        System.out.println("setRol");
        String rol = "";
        Usuario instance = null;
        instance.setRol(rol);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Usuario instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
