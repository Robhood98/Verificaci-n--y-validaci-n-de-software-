
package PuntodeVenta.Database;

import com.mycompany.puntodeventa.Provedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaleb
 */
public class ProvedorDAO {
   private Connection conexion;

   // Constructor que recibe la conexión
   public ProvedorDAO(Connection conexion) {
       this.conexion = conexion;
   }

   // Método para crear un proveedor
   public boolean crearProvedor(Provedor provedor) {
       String sql = "INSERT INTO provedores(empresa, nombre, correo, telefono, direccion) VALUES(?, ?, ?, ?, ?)";

       try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
           pstmt.setString(1, provedor.getEmpresa());
           pstmt.setString(2, provedor.getNombre_representante());
           pstmt.setString(3, provedor.getCorreo_representante());
           pstmt.setString(4, provedor.getTelefono());
           pstmt.setString(5, provedor.getDireccion());
           
           pstmt.executeUpdate();
           System.out.println("Proveedor registrado: " + provedor.getEmpresa());
           return true;
       } catch (SQLException ex) {
           // Registro de error con más detalles
           Logger.getLogger(ProvedorDAO.class.getName()).log(Level.SEVERE, "Error al insertar el proveedor", ex);
           return false;
       }
   }

   // Método para listar todos los proveedores
   public List<Provedor> listarProvedores() {
       List<Provedor> provedores = new ArrayList<>();
       String sql = "SELECT * FROM provedores";

       try (PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

           while (rs.next()) {
               Provedor provedor = new Provedor(
                   rs.getInt("id"),
                   rs.getString("empresa"),
                   rs.getString("nombre"),
                   rs.getString("correo"),
                   rs.getString("telefono"),
                   rs.getString("direccion")
               );
               provedores.add(provedor);
           }
       } catch (SQLException ex) {
           Logger.getLogger(ProvedorDAO.class.getName()).log(Level.SEVERE, "Error al listar los proveedores", ex);
       }

       return provedores;
   }

   // Método para leer un proveedor por correo
   public Provedor leerProvedorPorCorreo(String correo) {
       Provedor provedor = null;
       String sql = "SELECT * FROM provedores WHERE correo = ?";

       try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
           pstmt.setString(1, correo);
           try (ResultSet rs = pstmt.executeQuery()) {
               if (rs.next()) {
                   provedor = new Provedor(
                       rs.getInt("id"),
                       rs.getString("empresa"),
                       rs.getString("nombre"),
                       rs.getString("correo"),
                       rs.getString("telefono"),
                       rs.getString("direccion")
                   );
               }
           }
       } catch (SQLException ex) {
           Logger.getLogger(ProvedorDAO.class.getName()).log(Level.SEVERE, "Error al leer el proveedor", ex);
       }

       return provedor;
   }

   // Método para actualizar un proveedor
   public void actualizarProvedor(Provedor provedor) {
       String sql = "UPDATE provedores SET empresa = ?, nombre = ?, correo = ?, telefono = ?, direccion = ? WHERE id = ?";

       try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
           pstmt.setString(1, provedor.getEmpresa());
           pstmt.setString(2, provedor.getNombre_representante());
           pstmt.setString(3, provedor.getCorreo_representante());
           pstmt.setString(4, provedor.getTelefono());
           pstmt.setString(5, provedor.getDireccion());
           pstmt.setInt(6, provedor.getId());

           pstmt.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(ProvedorDAO.class.getName()).log(Level.SEVERE, "Error al actualizar el proveedor", ex);
       }
   }

   // Método para eliminar un proveedor
   public boolean eliminarProvedor(int id) {
       String sql = "DELETE FROM provedores WHERE id = ?";

       try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
           pstmt.setInt(1, id);
           pstmt.executeUpdate();
           return true;
       } catch (SQLException ex) {
           Logger.getLogger(ProvedorDAO.class.getName()).log(Level.SEVERE, "Error al eliminar el proveedor", ex);
           return false;
       }
   }
}
