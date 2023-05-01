package Ventana;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

/**
 * La clase VentanaTabla representa una ventana que muestra una tabla de datos.
 */
public class VentanaTabla extends JFrame {

    // Atributos de la clase
    private String[][] datos;           // Los datos a mostrar en la tabla
    private String[] nombreColumnas;    // Los nombres de las columnas de la tabla

    /**
     * Constructor de la clase. Recibe los datos a mostrar y los nombres de las columnas.
     * Crea una tabla y la añade a la ventana.
     * @param datos Los datos a mostrar en la tabla
     * @param nombreColumnas Los nombres de las columnas de la tabla
     */
    public VentanaTabla(String[][] datos, String[] nombreColumnas) {
        // Llama al constructor de la clase base JFrame con el título de la ventana
        super("Lista de datos");

        // Guarda los datos y los nombres de las columnas en los atributos de la clase
        this.datos = datos;
        this.nombreColumnas = nombreColumnas;

        // Crea la tabla y la añade a la ventana
        generarTabla();

        // Establece la posición de la ventana en el centro de la pantalla y la hace no redimensionable
        super.setLocationRelativeTo(null);
        super.setResizable(false);

        // Hace visible la ventana
        this.pack();
        this.setVisible(true);
    }

    /**
     * Sobrescribe el método isCellEditable de DefaultTableModel para que no se puedan editar las celdas de la tabla.
     * @param row La fila de la celda que se está consultando
     * @param column La columna de la celda que se está consultando
     * @return false, indicando que las celdas no son editables
     */

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /**
     * Crea la tabla y la añade a la ventana.
     */
    public void generarTabla() {
        // Crea un modelo de tabla con los datos y los nombres de las columnas
        DefaultTableModel dtm = new DefaultTableModel(this.datos, this.nombreColumnas) {
            // Sobrescribe el método isCellEditable para que no se puedan editar las celdas de la tabla

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Crea la tabla y le asigna el modelo de tabla
        final JTable tabla = new JTable(dtm);

        // Establece el tamaño preferido de la tabla
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 200));

        // Crea un JScrollPane para hacer la tabla desplazable
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Añade el JScrollPane al contenedor principal de la ventana
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Añade un WindowListener para detectar el evento de cierre de la ventana
        addWindowListener(new WindowAdapter() {
            // Sobrescribe el método windowClosing para que llame al método cerrarVentana()
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }
        });
    }

    /**
     * Cierra la ventana.
     */
    private void cerrarVentana() {
        this.dispose();
    }
}
