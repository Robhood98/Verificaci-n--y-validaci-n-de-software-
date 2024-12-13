
package com.mycompany.puntodeventa;

import PuntodeVenta.Database.ConexionSQLite;
import PuntodeVenta.Database.ProvedorDAO;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author kaleb
 */
public class MenuProvedores {
 private final Connection conexion;
    private final ProvedorDAO provedorDAO;
    
    public MenuProvedores() {
        conexion = ConexionSQLite.conectar();
        provedorDAO = new ProvedorDAO(conexion);
    }
    
    private void printMenu(){
        
    }
    
    public void MenuProvedoresLoop(){
        
    }
    
    private List<Provedor> leerProvedores(){
        return provedorDAO.listarProvedores();
    }
    
    private void registrarProvedor(){
        
    }
    
    private void editarProvedor(){
        
    }
    
    private void editarNombre(){
        
    }
    
    private void editarCorreo(){
        
    }
    
    private void editarTelefono(){
        
    }
    
    private void editarDireccion(){
        
    }
}