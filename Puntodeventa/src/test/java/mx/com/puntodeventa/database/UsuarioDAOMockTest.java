
package mx.com.puntodeventa.database;

import PuntodeVenta.Database.UsuarioDAO;
import com.mycompany.puntodeventa.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @autor kaleb

 */
public class UsuarioDAOMockTest {
    
    private UsuarioDAO usuarioDAOMock;
    private final String correo = "kbernal@ucgdl.edu.mx";
    
    private Usuario crearUsuario(){
        return new Usuario(9, "Keyla Bernal", "kbernal@ucgdl.edu.mx","12345", "admin");
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
        Mockito.when(usuarioDAOMock.leerUsuarioPorCorreo(this.correo))
                .thenReturn(usuario);
        
        Usuario lectura = usuarioDAOMock.leerUsuarioPorCorreo(this.correo);
        
        Mockito.verify(usuarioDAOMock).crearUsuario(usuario);
        
        Assert.assertEquals(lectura.getNombre(), usuario.getNombre());
        Assert.assertEquals(lectura.getCorreo(), usuario.getCorreo());
        Assert.assertEquals(lectura.getContra(), usuario.getContra());
        Assert.assertEquals(lectura.getRol(), usuario.getRol());
    }
        
    @Test
    public void _001_2_UsuarioExistente(){
        
        usuarioDAOMock = Mockito.mock(UsuarioDAO.class);
        
        Usuario usuario = crearUsuario();
        
        Mockito.when(usuarioDAOMock.crearUsuario(usuario))
                .thenReturn(Boolean.FALSE);
        
        boolean crear = usuarioDAOMock.crearUsuario(usuario);
        
        Mockito.verify(usuarioDAOMock).crearUsuario(usuario);
        
        Assert.assertFalse(crear);
    }
    
    @Test
    public void _002_1_testLeerUsuarioPorCorreo() {
        // Crear usuario simulado
        usuarioDAOMock = Mockito.mock(UsuarioDAO.class);
        
        Usuario usuario = crearUsuario();
        
        // Simular respuesta de lectura
        Mockito.when(usuarioDAOMock.leerUsuarioPorCorreo(this.correo))
                .thenReturn(usuario);
        
        Usuario lectura = usuarioDAOMock.leerUsuarioPorCorreo(this.correo);
        
        Mockito.verify(usuarioDAOMock).leerUsuarioPorCorreo(this.correo);
        
        Assert.assertEquals(lectura.getNombre(), usuario.getNombre());
        Assert.assertEquals(lectura.getCorreo(), usuario.getCorreo());
        Assert.assertEquals(lectura.getContra(), usuario.getContra());
        Assert.assertEquals(lectura.getRol(), usuario.getRol());
    }

    @Test
    public void _002_2_LeerUsuarioNoExistente(){
        
    }
    
    @Test
    public void _003_1_testActualizarNombre(){
        
    }
    
    @Test
    public void _003_2_testActualizarContrasena(){
        
    }
    
    @Test
    public void _003_3_testActualizarRol(){
        
    }
    
    @Test
    public void _004_testEliminarUsuario(){
        
    }
}
