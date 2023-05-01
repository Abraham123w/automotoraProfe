package Ventana;

import Controller.AutomotoraController;
import Model.Automotora;
import Ventana.*;

import javax.swing.*;
import java.awt.event.*;

public class VentanaMenuBienvenida extends Ventana {

    // Define un componente JLabel para mostrar texto descriptivo en la interfaz gráfica.
    private JLabel textoMenu;

    // Define varios botones JButton para permitir al usuario realizar diferentes acciones en la interfaz gráfica.
    private JButton botonRegistrarCliente;
    private JButton botonSalida;
    private JButton botonRegistrarVehiculo;
    private JButton botonBuscarVehiculo;
    private JButton botonVenderVehiculo;

    // Define una instancia de la clase Automotora, que se utilizará para interactuar con los datos de la aplicación.
    private Automotora automotora;


    public VentanaMenuBienvenida(Automotora automotora) {
        super("Menu ventas", 500, 520);
        this.automotora=automotora;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonRegistrarCliente();
        generarBotonRegistrarVehiculo();
        generarBotonBuscarVehiculo();
        // generarBotonVenderVehiculo();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Sistema de Venta de Vehiculos";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 30, 500, 30);
    }

    private void generarBotonRegistrarCliente() {
        String textoBoton = "Registrar Cliente";

        this.botonRegistrarCliente = super.generarBoton(textoBoton, 175, 100, 150, 40);
        //El botón recién creado se agrega al panel que ejecuta este código.
        this.add(this.botonRegistrarCliente);
         /*Se agrega un escuchador de eventos al botón, lo que significa que se ejecutará un código cuando el botón
       sea presionado. El objeto que implementa el escuchador de eventos se especifica como this, lo que significa que el
       objeto que está ejecutando este código (probablemente un JPanel) también implementa la interfaz de escuchador de
       eventos y manejará los eventos del botón.
        */
        this.botonRegistrarCliente.addActionListener(this);
    }
    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 175, 420, 150, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }
    private void generarBotonRegistrarVehiculo() {
        String textoBoton = "Registrar vehiculo";
        this.botonRegistrarVehiculo = super.generarBoton(textoBoton, 175, 180, 150, 40);
        this.add(this.botonRegistrarVehiculo);
        this.botonRegistrarVehiculo.addActionListener(this);
    }
    private void generarBotonBuscarVehiculo(){
        String textoBoton = "Buscar Vehiculo";
        this.botonBuscarVehiculo=super.generarBoton(textoBoton, 175, 260, 150, 40);
        this.add(this.botonBuscarVehiculo);
        this.botonBuscarVehiculo.addActionListener(this);
    }
    private void generarBotonVenderVehiculo(){
        String textoBoton = "Vender Vehiculo";
        this.botonVenderVehiculo=super.generarBoton(textoBoton, 175, 340, 150, 40);
        this.add(this.botonVenderVehiculo);
        this.botonVenderVehiculo.addActionListener(this);
    }

/*Este es un método que implementa la interfaz ActionListener. La interfaz ActionListener se utiliza para manejar
 eventos de acción generados por componentes Swing, como botones.
  */
    public void actionPerformed(ActionEvent e) {
        /* Se verifica si el evento de acción fue generado por el botón botonRegistrarCliente.
        Si es así, se crea una nueva ventana para registrar un cliente y se cierra la ventana actual.*/
        if (e.getSource() == this.botonRegistrarCliente) {
            VentanaRegistrarCliente ventanaRegistrarCliente= new VentanaRegistrarCliente(automotora);
            //Cierra la ventana actual
            this.dispose();
        }
        if(e.getSource() == this.botonRegistrarVehiculo){
            VentanaRegistroVehiculo ventanaRegistroVehiculo= new VentanaRegistroVehiculo(automotora);
            this.dispose();
        }
        if(e.getSource() == this.botonBuscarVehiculo){
            VentanaBusquedaVehiculo ventanaBusquedaVehiculo= new VentanaBusquedaVehiculo(automotora);
            this.dispose();
        }
       /*Se verifica si el evento de acción fue generado por el botón botonVenderVehiculo. Si es así,
       se muestra un mensaje de diálogo informativo.*/
        if(e.getSource() == this.botonVenderVehiculo){
            JOptionPane.showMessageDialog(this,"Próximamente","Mensaje Informativo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
      /* Se verifica si el evento de acción fue generado por el botón botonSalida. Si es así, se almacenan los datos
      de la automotora, se cierra la ventana actual y se cierra la aplicación.*/
        if(e.getSource() == this.botonSalida){
            AutomotoraController.almacenarDatos(this.automotora);
            this.dispose();
            System.exit(0);
        }

    }
}