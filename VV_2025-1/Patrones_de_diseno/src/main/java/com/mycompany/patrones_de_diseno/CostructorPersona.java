

package com.mycompany.patrones_de_diseno;

/**
 *
 * @author chris
 */
public class ConstructorPersona {
    private String nombre = "NA";
    private String apellido = "NA";
    private String correo = "NA";
    private String telefono = "NA";
    private String ocupacion = "NA";
    private String edad = "NA";
    
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public void setOcupacion(String ocupacion){
        this.ocupacion = ocupacion;
    }
    
    public void setEdad(String edad){
        this.edad = edad;
    }
    
    public Persona construir(){
        return new Persona(nombre, apellido, correo,
                telefono, ocupacion,edad);
    }
}