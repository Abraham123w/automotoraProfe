package Controller;

import Model.Data.GestorDatos;
import Model.Automotora;
import Model.ColorVehiculo;
import Model.MarcaVehiculo;
import Model.Vehiculo;

import java.util.List;

public class AutomotoraController {

    public static Automotora cargaMasivaDatos(Automotora automotora){
        GestorDatos.leerArchivoVendedores(automotora, "C:/Users/abrah/OneDrive/Escritorio/Auni2023/TAREAS LAB PROGRAMACION/automotora profe/vendedores.txt");
        GestorDatos.leerArchivoClientes(automotora, "C:/Users/abrah/OneDrive/Escritorio/Auni2023/TAREAS LAB PROGRAMACION/automotora profe/clientes.txt");
        GestorDatos.leerArchivoVehiculos(automotora, "C:/Users/abrah/OneDrive/Escritorio/Auni2023/TAREAS LAB PROGRAMACION/automotora profe/vehiculos.txt");
        return automotora;
    }
    public static List buscarVehiculo(Automotora automotora, String nombre){
        return automotora.buscarAutoNombre(nombre);
    }
    public static Vehiculo agregarVehiculo(Automotora automotora, String nombre, ColorVehiculo color, MarcaVehiculo marca,
                                           int año, int precio, double kmRecorridos){
        return automotora.añadirVehiculo(nombre,color,marca,año,precio,kmRecorridos);
    }
    public static boolean removerVehiculo(Automotora automotora, String nombre, int año){
        return automotora.removerVehiculo(nombre,año);
    }
    public static void almacenarDatos(Automotora automotora) {
        // Se registran los datos de los clientes en un archivo llamado "clientes.txt"
        GestorDatos.registrarDatos(automotora.getClientes(), "clientes.txt");

        // Se registran los datos de los vendedores en un archivo llamado "vendedores.txt"
        GestorDatos.registrarDatos(automotora.getVendedores(), "vendedores.txt");

        // Se registran los datos de los vehículos a la venta en un archivo llamado "vehiculos.txt"
        GestorDatos.registrarDatos(automotora.getVehiculosAVenta(), "vehiculos.txt");
    }
}
