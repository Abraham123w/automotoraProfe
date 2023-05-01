package Model.Data;

import Model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GestorDatos {

    public static Automotora leerArchivoClientes(Automotora automotora, String direccionArchivo) {
        String textoArchivo = "";

        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            //Lee cada linea del archivo hasta que la linea sea nula
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                automotora.getClientes().add(new Cliente(data[0], data[1], data[2], data[3], data[4]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        return automotora;
    }

    public static Automotora leerArchivoVendedores(Automotora automotora, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            //Lee cada linea del archivo hasta que la linea sea nula
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                automotora.getVendedores().add(new Vendedor(data[0], data[1], Integer.parseInt(data[2])));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        return automotora;
    }

    public static Automotora leerArchivoVehiculos(Automotora automotora, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            //Lee cada linea del archivo hasta que la linea sea nula
            while ((textoArchivo = br.readLine()) != null) {
                System.out.println("encontré el archivo");
                String[] data = textoArchivo.split(",");
                automotora.getVehiculosAVenta().add(new Vehiculo(data[0], ColorVehiculo.valueOf(data[1].toUpperCase()), MarcaVehiculo.valueOf(data[2].toUpperCase()), Integer.parseInt(data[3]), Integer.parseInt(data[4]), Double.parseDouble(data[5])));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        return automotora;
    }

    public static boolean registrarDato(Object objeto, String direccionArchivo) {
        boolean lineaVacia = false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (lineaVacia == false) {
                bw.newLine();
            }
            bw.write(objeto.toString());

            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
            return false;
        }
    }

    /**
     * Registra los datos de una lista de objetos en un archivo de texto.
     * @param objetos la lista de objetos a registrar.
     * @param direccionArchivo la dirección del archivo de texto.
     * @return true si se registraron los datos correctamente, false si no.
     */
    public static boolean registrarDatos(List objetos, String direccionArchivo) {
        try {
            // Se crea un objeto File con la dirección del archivo.
            File file = new File(direccionArchivo);

            // Si el archivo ya existe, se borra.
            if (Files.deleteIfExists(Paths.get("C:\\Users\\Oscar\\Documents\\Proyectos de Software\\Programación ICC264\\Automotora\\" + direccionArchivo))) {
                System.out.println("El fichero ha sido borrado satisfactoriamente");
            } else {
                System.out.println("El fichero no puede ser borrado");
            }

            // Se crea un nuevo archivo con la dirección especificada.
            File fichero = new File(direccionArchivo);
            fichero.createNewFile();

            // Se crea un objeto FileWriter y BufferedWriter para escribir en el archivo.
            FileWriter fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Se escribe cada objeto de la lista en una línea del archivo.
            for (Object objeto : objetos) {
                bw.write(objeto.toString());
                bw.newLine();
            }

            // Se cierran los objetos BufferedWriter y FileWriter.
            bw.close();
            fw.close();

            // Se retorna true indicando que se registraron los datos correctamente.
            return true;

        } catch (Exception e) {
            // Si ocurre una excepción, se imprime el mensaje de la excepción y se retorna false.
            System.out.println(e.getMessage());
            return false;
        }
    }

}


