
package com.mycompany.puntodeventa.newpackage;

import mx.com.vafis.puntodeventa.Usuario;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class UsuarioDAOMockTest {
    
    private UsuarioDAO usuarioDAOMock;
    
    private Usuario crearUsuario(){
        return new Usuario(9, "Pedro Valenzuela", "jvalenzuela@ucgdl.edu.mx","12345", "admin");
    }
    
    
    @Test
    public void _001_1_testCrearUsuario() {
        // Crear usuario simulado
        usuarioDAOMock = Mockito.mock(UsuarioDAO.class);
        
        Usuario usuario = crearUsuario();
                
        // Simular respuesta de metodo crearUsuario
        Mockito.when(usuarioDAOMock.crearUsuario(usuario))
                .thenReturn(Boolean.TRUE);
        
        usuarioDAOMock.crearUsuario(usuario);
        
        // Simular respuesta de lectura
        Mockito.when(usuarioDAOMock.leerUsuarioPorCorreo("jvalenzuela@ucgdl.edu.mx"))
                .thenReturn(usuario);
        
        Usuario lectura = usuarioDAOMock.leerUsuarioPorCorreo("jvalenzuela@ucgdl.edu.mx");
        
        Mockito.verify(usuarioDAOMock).crearUsuario(usuario);
        
        assertEquals(lectura.getNombre(), usuario.getNombre());
        assertEquals(lectura.getCorreo(), usuario.getCorreo());
        assertEquals(lectura.getContra(), usuario.getContra());
        assertEquals(lectura.getRol(), usuario.getRol());
    }
        
    @Test
    public void _001_2_UsuarioExistente(){
        
        usuarioDAOMock = Mockito.mock(UsuarioDAO.class);
        
        Usuario usuario = crearUsuario();
        
        Mockito.when(usuarioDAOMock.crearUsuario(usuario))
                .thenReturn(Boolean.FALSE);
        
        boolean crear = usuarioDAOMock.crearUsuario(usuario);
        
        Mockito.verify(usuarioDAOMock).crearUsuario(usuario);
        
        assertFalse(crear);
    }
    
    @Test
    public void _002_1_testLeerUsuarioPorCorreo() {
        // Crear usuario simulado
        usuarioDAOMock = Mockito.mock(UsuarioDAO.class);
        
        Usuario usuario = crearUsuario();
        
        // Simular respuesta de lectura
        Mockito.when(usuarioDAOMock.leerUsuarioPorCorreo("jvalenzuela@ucgdl.edu.mx"))
                .thenReturn(usuario);
        
        Usuario lectura = usuarioDAOMock.leerUsuarioPorCorreo("jvalenzuela@ucgdl.edu.mx");
        
        Mockito.verify(usuarioDAOMock).leerUsuarioPorCorreo("jvalenzuela@ucgdl.edu.mx");
        
        assertEquals(lectura.getNombre(), usuario.getNombre());
        assertEquals(lectura.getCorreo(), usuario.getCorreo());
        assertEquals(lectura.getContra(), usuario.getContra());
        assertEquals(lectura.getRol(), usuario.getRol());
    }
}
