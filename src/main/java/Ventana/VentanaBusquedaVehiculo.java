package Ventana;

import Model.Automotora;
import Model.ColorVehiculo;
import Model.MarcaVehiculo;
import Model.Vehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaBusquedaVehiculo extends Ventana {
    private JTextField campoNombre; // campo de texto para ingresar el nombre del vehículo a buscar
    private JButton botonBuscar; // botón para realizar la búsqueda
    private JButton botonRegresar; // botón para volver a la ventana anterior
    private JComboBox listaMarca; // lista desplegable para seleccionar una marca de vehículo

    private JLabel textoEncabezado; // texto para el encabezado de la ventana
    private JLabel textoNombre; // texto para indicar la búsqueda por nombre
    private JLabel textoMarca; // texto para indicar la búsqueda por marca


    private Automotora automotora; // objeto que representa la automotora en la que se realiza la búsqueda


    public VentanaBusquedaVehiculo(Automotora automotora) {
        super("Búsqueda de Vehículo", 500, 520);
        this.automotora= automotora;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarCampoNombre();
        generarBotonBuscarVehiculo();
        generarBotonCancelar();
        generarListaMarcaVehiculo();
    }
    private void generarCampoNombre(){
        String textoNombre= "Modelo Vehículo:"; // texto que se mostrará junto al campo de texto
        // crea un JLabel con el texto y lo agrega a la ventana
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        // crea un JTextField y lo asigna al atributo campoNombre
        this.campoNombre= super.generarJTextField(200,50,250,20);
        // agrega el campo de texto a la ventana
        this.add(this.campoNombre); // agrega el campo de texto a la ventana
    }

    private void generarListaMarcaVehiculo(){
        // crea un JLabel con el texto y lo agrega a la ventana
        super.generarJLabel(this.textoMarca,"Marca vehículo:",20,100,100,20);
        // crea una lista desplegable con los valores de la enumeración MarcaVehiculo y lo asigna al atributo listaMarca
        this.listaMarca=super.generarListaDesplegable(MarcaVehiculo.values(),120,100, 100, 20);
        this.add(this.listaMarca); // agrega la lista desplegable a la ventana
    }

    private void generarBotonBuscarVehiculo() {
        String textoBoton= "Buscar Vehículo";
        this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonBuscar);
        this.botonBuscar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonRegresar = "Regresar";
        this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
        this.add(this.botonRegresar);
        this.botonRegresar.addActionListener(this);
    }
    private String[][] registrarVehiculo() {
        // Crear una lista de vehículos y una matriz de cadenas para almacenar los detalles de los vehículos
        List<Vehiculo> vehiculos = new ArrayList<>();
        String[][] datosVehiculos;

        // Verificar si el campo de nombre está vacío
        if (this.campoNombre.getText().length() == 0) {
            // Si está vacío, llamar al método "buscarAutoMarca" y almacenar el resultado en la lista de vehículos
            vehiculos = automotora.buscarAutoMarca((MarcaVehiculo) this.listaMarca.getSelectedItem());
        } else {
            // Si no está vacío, llamar al método "buscarAutoNombre" y almacenar el resultado en la lista de vehículos
            vehiculos = automotora.buscarAutoNombre(this.campoNombre.getText());
        }

        // Crear una matriz de cadenas con el tamaño de la lista de vehículos y asignar los detalles de cada vehículo a la matriz
        datosVehiculos = new String[vehiculos.size()][6];
        for (int i = 0; i < vehiculos.size(); i++) {
            datosVehiculos[i][0] = vehiculos.get(i).getNombre();
            datosVehiculos[i][1] = vehiculos.get(i).getMarca().getMarcaVehiculo();
            datosVehiculos[i][2] = Integer.toString(vehiculos.get(i).getAño());
            datosVehiculos[i][3] = vehiculos.get(i).getColor();
            datosVehiculos[i][4] = Integer.toString(vehiculos.get(i).getPrecio());
            datosVehiculos[i][5] = Double.toString(vehiculos.get(i).getKmRecorridos());
        }

        // Devolver la matriz de cadenas como el resultado del método
        return datosVehiculos;
    }

    /**
     * Este método se llama cuando se produce un evento de acción en la ventana.
     * Si el evento es causado por el botón de búsqueda, se crea una instancia de la clase "VentanaTabla"
     * con los detalles de los vehículos encontrados y se muestra la ventana.
     * Si el evento es causado por el botón de regresar, se crea una instancia de la clase "VentanaMenuBienvenida"
     * y se cierra la ventana actual.
     *
     * @param e el evento de acción que se ha producido
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonBuscar) {
            // Si el evento es causado por el botón de búsqueda, se crea una instancia de la clase "VentanaTabla"
            // con los detalles de los vehículos encontrados y se muestra la ventana.
            String[] nombreColumnas = {"Modelo", "Marca", "Año", "Color", "Precio", "Kilómetros Recorridos"};
            VentanaTabla ventanaTabla = new VentanaTabla(registrarVehiculo(), nombreColumnas);
        }
        if (e.getSource() == this.botonRegresar) {
            // Si el evento es causado por el botón de regresar, se crea una instancia de la clase "VentanaMenuBienvenida"
            // y se cierra la ventana actual.
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(automotora);
            this.dispose();
        }
    }

}
