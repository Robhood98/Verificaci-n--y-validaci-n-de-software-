
package com.mycompany.puntodeventa;

/**
 *
 * @author kaleb
 */
public class Provedor {
private int id;
    private String empresa;
    private String nombre_representante;
    private String correo_representante;
    private String telefono;
    private String direccion;

    public Provedor(int id, String empresa, String nombre_representante, String correo_representante, String telefono, String direccion) {
        this.id = id;
        this.empresa = empresa;
        this.nombre_representante = nombre_representante;
        this.correo_representante = correo_representante;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
        public int getId() {
        return id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getNombre_representante() {
        return nombre_representante;
    }

    public String getCorreo_representante() {
        return correo_representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setNombre_representante(String nombre_representante) {
        this.nombre_representante = nombre_representante;
    }

    public void setCorreo_representante(String correo_representante) {
        this.correo_representante = correo_representante;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
        
}