
package com.mycompany.puntodeventa;

import PuntodeVenta.Database.ConexionSQLite;
import PuntodeVenta.Database.UsuarioDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kaleb
 */
public class MenuEmpleados {
    private final String PREFIX = "\n".repeat(25);
    private final String LINEA_HORIZONTAL = "+" + "-".repeat(72) + "+";

    private final Connection conexion;
    private final UsuarioDAO usuarioDAO;

    private List<Usuario> empleados = new ArrayList<>();

    Scanner kb = new Scanner(System.in);

    public MenuEmpleados() {
        conexion = ConexionSQLite.conectar();
        usuarioDAO = new UsuarioDAO(conexion);
    }

    private void printMenu() {
        System.out.println(LINEA_HORIZONTAL);
        System.out.println("| ID  |        NOMBRE        |             CORREO             |   ROL    |");
        System.out.println(LINEA_HORIZONTAL);

        for (Usuario u : empleados) {
            String id = String.format("| %3s ", u.getId());
            String nombre = String.format("| %-20.20s ", u.getNombre());
            String correo = String.format("| %-30.30s ", u.getCorreo());
            String rol = String.format("| %-8s |", u.getRol());

            System.out.println(id + nombre + correo + rol);
        }

        System.out.println(LINEA_HORIZONTAL);
        System.out.println("\n\n1) Registrar\t2) Editar\tM) Menu Principal");
    }

    public void MenuEmpleadosLoop() {
        boolean regresar = false;
        do {
            empleados = leerEmpleados();

            if (empleados == null) {
                System.err.println("Error al leer los empleados. Inténtalo de nuevo.");
                return;
            }

            System.out.println(PREFIX + "          EMPLEADOS         ");
            printMenu();
            System.out.print("Selecciona una opción: ");

            String seleccion = kb.nextLine();

            switch (seleccion) {
                case "1":
                    registrarEmpleado();
                    break;

                case "2":
                    System.out.print("Ingresa id de usuario a editar: ");
                    try {
                        int id = Integer.parseInt(kb.nextLine());

                        boolean idValido = false;
                        for (Usuario u : empleados) {
                            if (u.getId() == id) {
                                idValido = true;
                                editarEmpleado(u);
                                break;
                            }
                        }

                        if (!idValido) {
                            System.err.println("El id " + id + " no es válido");
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Por favor, ingresa un número válido.");
                    }
                    break;

                case "M":
                    regresar = true;
                    break;

                default:
                    System.out.println("Selección no válida.");
            }
        } while (!regresar);
    }

    private List<Usuario> leerEmpleados() {
        return usuarioDAO.leerTodosLosUsuarios();
    }

    private void registrarEmpleado() {
        boolean finalizarRegistro = false;

        do {
            System.out.println(PREFIX + "          REGISTRAR          ");

            System.out.print("\nIngresar nombre completo: ");
            String nombre = kb.nextLine();

            System.out.print("\nIngresar correo: ");
            String correo = kb.nextLine();

            String contra;

            boolean iguales = false;
            do {
                System.out.print("\nIngresar contraseña: ");
                contra = kb.nextLine();

                System.out.print("\nConfirmar contraseña: ");
                String confirmacion = kb.nextLine();

                if (contra.equals(confirmacion)) {
                    iguales = true;
                } else {
                    System.err.println("Las contraseñas no coinciden");
                }

            } while (!iguales);

            String rol = seleccionarRol();

            Usuario nuevo = new Usuario(0, nombre, correo, contra, rol);

            System.out.println("Registrar");
            System.out.println(nuevo);

            System.out.print("¿Los datos son correctos? [s]/N: ");
            String dc = kb.nextLine().trim().toLowerCase();

            if (dc.equals("s")) {
                boolean success = usuarioDAO.crearUsuario(nuevo);
                if (!success) {
                    System.out.println("Error al registrar Empleado");
                }
                finalizarRegistro = true;
            }
        } while (!finalizarRegistro);
    }

    private void editarEmpleado(Usuario empleado) {
        boolean finalizarEdicion = false;

        do {
            System.out.println(PREFIX + "          EDITAR " + empleado.getNombre() + "          ");
            System.out.println(empleado.getId() + "\t" + empleado.getNombre() + "\t" + empleado.getCorreo() + "\t" + empleado.getRol());

            System.out.println("\n1) Cambiar nombre");
            System.out.println("\n2) Cambiar contraseña");
            System.out.println("\n3) Cambiar rol");

            System.out.println("\n\nM) Menu Empleado");

            System.out.print("Selecciona una opción: ");
            String seleccion_editar = kb.nextLine();

            switch (seleccion_editar) {
                case "1":
                    editarNombre(empleado);
                    break;

                case "2":
                    System.out.println("No se ha implementado menu Cambiar contraseña ");
                    break;

                case "3":
                    editarRol(empleado);
                    break;

                case "M":
                    finalizarEdicion = true;
                    break;

                default:
                    System.out.println("Selección no válida.");
            }
        } while (!finalizarEdicion);
    }

    private void editarNombre(Usuario empleado) {
        boolean editarNombreFinalizado = false;

        do {
            System.out.print("Ingresa nuevo nombre: ");
            String nuevoNombre = kb.nextLine();

            System.out.println("Cambiando nombre de " + empleado.getNombre() + " a " + nuevoNombre);

            System.out.print("¿Los datos son correctos? [s]/N: ");
            String dc = kb.nextLine().trim().toLowerCase();

            if (dc.equals("s")) {
                empleado.setNombre(nuevoNombre);
                usuarioDAO.actualizarUsuario(empleado);
                editarNombreFinalizado = true;
            }
        } while (!editarNombreFinalizado);
    }

    private void editarRol(Usuario empleado) {
        String rol = seleccionarRol();
        empleado.setRol(rol);
        usuarioDAO.actualizarUsuario(empleado);
    }

    private String seleccionarRol() {
        String rol = null;
        do {
            System.out.println("\nRoles: ");
            System.out.println("1) Admin");
            System.out.println("2) Vendedor");
            System.out.println("3) Almacenista");

            System.out.print("\nSelecciona un rol: ");
            String seleccion_rol = kb.nextLine();

            switch (seleccion_rol) {
                case "1":
                    rol = "Admin";
                    break;
                case "2":
                    rol = "Vendedor";
                    break;
                case "3":
                    rol = "Almacenista";
                    break;
                default:
                    System.out.println("Selección no válida.");
            }
        } while (rol == null);
        return rol;
    }
}
