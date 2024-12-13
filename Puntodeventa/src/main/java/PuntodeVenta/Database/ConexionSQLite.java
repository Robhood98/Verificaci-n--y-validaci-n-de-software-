
package PuntodeVenta.Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionSQLite {
    
    private static Connection conexion = null;
    private static final String URL = "jdbc:sqlite:puntodeventa.sqlite";
        
    private ConexionSQLite() {}
    
    public static Connection conectar(){
        if( conexion == null ){
            try {
                conexion = DriverManager.getConnection(URL);
                
                crearTablaUsuarios();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionSQLite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return conexion;
    }
    
    public static void cerrarConexion(){
        if( conexion != null){
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionSQLite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void crearTablaUsuarios(){
        try (Statement statement = conexion.createStatement()){
            String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "nombre TEXT NOT NULL,"
                    + "correo TEXT NOT NULL UNIQUE,"
                    + "contra TEXT NOT NULL,"
                    + "rol TEXT NOT NULL"
                    + ")";
            
            statement.execute(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
