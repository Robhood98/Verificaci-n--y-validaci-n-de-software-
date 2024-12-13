
package mx.com.puntodeventa.database;

import PuntodeVenta.Database.ConexionSQLite;
import PuntodeVenta.Database.UsuarioDAO;
import com.mycompany.puntodeventa.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * @autor kaleb

 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDAOTest {
    
    private static Connection conexion;
    private static UsuarioDAO usuarioDAO;
    
    private Usuario usuario;
    private final String correo = "robin.edu.mx";
    
    public UsuarioDAOTest() {
    }
    
    private Usuario crearUsuario(){
        return new Usuario(9, "Robin Villasenor", "robin@ucgdl.edu.mx","12345", "admin");
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
        conexion = ConexionSQLite.conectar();        
        usuarioDAO = new UsuarioDAO(conexion);
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        if(conexion != null){
            conexion.close();
        }
    }
    
    @Before
    public void setUp(){
        usuario = usuarioDAO.leerUsuarioPorCorreo(correo);
        
        if(usuario != null){
            usuarioDAO.eliminarUsuario(usuario.getId());
            usuario = null;
        }
        
        // usuario = new Usuario(9, "Pedro Valenzuela", "jvalenzuela@ucgdl.edu.mx","12345", "admin");
    }

    @Test
    public void _001_1_testCrearUsuario() {
        System.out.println("crearUsuario");
        usuario = crearUsuario();
        
        usuarioDAO.crearUsuario(usuario);
        
        Usuario lectura = usuarioDAO.leerUsuarioPorCorreo(correo);
        
        assertEquals(lectura.getNombre(), usuario.getNombre());
        assertEquals(lectura.getCorreo(), usuario.getCorreo());
        assertEquals(lectura.getContra(), usuario.getContra());
        assertEquals(lectura.getRol(), usuario.getRol());
    }
    
    @Test
    public void _001_2_UsuarioExistente(){
        System.out.println("Usuario existente");
        usuario = crearUsuario();
        
        boolean crear1 = usuarioDAO.crearUsuario(usuario);
        assertTrue(crear1);
        
        boolean crear2 = usuarioDAO.crearUsuario(usuario);
        assertFalse(crear2);
    }

    @Test
    public void _002_1_testLeerUsuarioPorCorreo() {
        System.out.println("leerUsuarioPorCorreo");
        
        Usuario expResult = crearUsuario();
        usuarioDAO.crearUsuario(expResult);
        
        Usuario result = usuarioDAO.leerUsuarioPorCorreo(correo);
        
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getCorreo(), result.getCorreo());
        assertEquals(expResult.getContra(), result.getContra());
        assertEquals(expResult.getRol(), result.getRol());
        
        //assertEquals(expResult, result);
    }

    @Test
    public void _002_2_LeerUsuarioNoExistente(){
        Usuario instance = usuarioDAO.leerUsuarioPorCorreo(correo);
        
        assertEquals(instance, null);
    }
    
    @Test
    public void _003_1_testActualizarNombre() {
        System.out.println("actualizarUsuario");
        
        // Crear usuario para asegurar que se encuentra el usuario en la base de datos
        Usuario crear = new Usuario(9, "Robin", "robin@ucgdl.edu.mx","Villasenor", "vendedor");
        
        // Guardar Usuario en base de datos
        usuarioDAO.crearUsuario(crear);
        
        // Leer usuario por correo
        Usuario leer = usuarioDAO.leerUsuarioPorCorreo(correo);
        
        // Modificar contraseña
        String nombre = "Chris";
        leer.setNombre(nombre);
        
        // Actualizar usuario
        usuarioDAO.actualizarUsuario(leer);
        
        // Leer Usuario por correo
        Usuario actualizado = usuarioDAO.leerUsuarioPorCorreo(correo);
        
        assertEquals(actualizado.getNombre(), nombre);
        assertEquals(actualizado.getCorreo(), leer.getCorreo());
        assertEquals(actualizado.getContra(), leer.getContra());
        assertEquals(actualizado.getRol(), leer.getRol());
    }
    
    @Test
    public void _003_2_testActualizarContrasena() {
        System.out.println("actualizarUsuario");
        
        // Crear usuario para asegurar que se encuentra el usuario en la base de datos
        Usuario crear = new Usuario(9, "Keyla", "kbernal@ucgdl.edu.mx","Bernal", "admin");
        
        // Guardar Usuario en base de datos
        usuarioDAO.crearUsuario(crear);
        
        // Leer usuario por correo
        Usuario leer = usuarioDAO.leerUsuarioPorCorreo(correo);
        
        // Modificar contraseña
        String contra = "12345";
        leer.setContra(contra);
        
        // Actualizar usuario
        usuarioDAO.actualizarUsuario(leer);
        
        // Leer Usuario por correo
        Usuario actualizado = usuarioDAO.leerUsuarioPorCorreo(correo);
        
        assertEquals(actualizado.getNombre(), leer.getNombre());
        assertEquals(actualizado.getCorreo(), leer.getCorreo());
        assertEquals(actualizado.getContra(), contra);
        assertEquals(actualizado.getRol(), leer.getRol());
    }
    
    @Test
    public void _003_3_testActualizarRol() {
        System.out.println("actualizarUsuario");
        
        // Crear usuario para asegurar que se encuentra el usuario en la base de datos
        Usuario crear = new Usuario(9, "Keyla", "kbernal@ucgdl.edu.mx","Bernal", "admin");
        
        // Guardar Usuario en base de datos
        usuarioDAO.crearUsuario(crear);
        
        // Leer usuario por correo
        Usuario leer = usuarioDAO.leerUsuarioPorCorreo(correo);
        
        // Modificar contraseña
        String rol = "Vendedor";
        leer.setRol(rol);
        
        // Actualizar usuario
        usuarioDAO.actualizarUsuario(leer);
        
        // Leer Usuario por correo
        Usuario actualizado = usuarioDAO.leerUsuarioPorCorreo(correo);
        
        assertEquals(actualizado.getNombre(), leer.getNombre());
        assertEquals(actualizado.getCorreo(), leer.getCorreo());
        assertEquals(actualizado.getContra(), leer.getContra());
        assertEquals(actualizado.getRol(), rol);
    }
    
    @Test
    public void _004_testEliminarUsuario() {
        System.out.println("eliminarUsuario");
        
        // Crear usuario para asegurar que se encuentra el usuario en la base de datos
        Usuario crear = crearUsuario();
        
        // Guardar Usuario en base de datos
        usuarioDAO.crearUsuario(crear);
        
        // Leer Usuario por correo
        Usuario leer = usuarioDAO.leerUsuarioPorCorreo(correo);
        
        int id = leer.getId();
        boolean res = usuarioDAO.eliminarUsuario(id);
        
        assertEquals(res, true);
        
        Usuario res2 = usuarioDAO.leerUsuarioPorCorreo(correo);
        assertNull(res2);
    }
       
}
