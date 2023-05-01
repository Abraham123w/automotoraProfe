package Model;
import java.awt.*;

public enum ColorVehiculo {
    // Definición de los elementos de la enumeración
    BLANCO("Blanco"),
    AZUL("Azul"),
    NEGRO("Negro"),
    PLATEADO("Plateado"),
    GRIS("Gris"),
    DORADO("Dorado"),
    VERDE("Verde");

    // Campo para almacenar el valor de cadena asociado con cada elemento de la enumeración
    private String colorVehiculo;

    // Constructor para asignar el valor de cadena asociado con cada elemento de la enumeración
    private ColorVehiculo(String colorVehiculo){
        this.colorVehiculo= colorVehiculo;
    }

    // Método público para obtener el valor de cadena asociado con cada elemento de la enumeración
    public String getColorVehiculo() {
        return colorVehiculo;
    }
}
