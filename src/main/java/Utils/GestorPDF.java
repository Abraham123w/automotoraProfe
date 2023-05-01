package Utils;

import Model.Venta;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.Date;

public class GestorPDF {

    public void generarBoleta(Venta venta) throws IOException {
        //Se crea un nuevo documento
        PDDocument documento = new PDDocument();
        //Al documento se le crea y agrega una nueva página, en este caso en formato A6
        PDPage pagina = new PDPage(PDRectangle.A6);
        documento.addPage(pagina);
        //Se genera un arreglo de líneas que va a tener el archivo PDF
        String[] lineasPdf= this.obtenerLíneasPdf(venta);
        this.rellenarPDF(documento,pagina,lineasPdf);
        //Se guarda el documento en la ubicación descrita
        documento.save(this.generarNombrePdf(venta.getFecha()));
        documento.close();

    }
    public void rellenarPDF(PDDocument documento, PDPage pagina, String[] lineasVenta){
        //Por cada linea del arreglo, se irá agregando texto
        try (PDPageContentStream contenidoPagina = new PDPageContentStream(documento, pagina)) {
            for(int linea=0; linea<lineasVenta.length; linea++) {
                contenidoPagina.beginText();
                //Se define en que posición del documento estará el texto
                contenidoPagina.newLineAtOffset(10, pagina.getMediaBox().getHeight()-(10*linea));

                //contenidoPagina.setFont(PDType1Font.HELVETICA_BOLD, 8f);
                //Agrega el texto al documento
                contenidoPagina.showText(lineasVenta[linea]);
                contenidoPagina.endText();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] obtenerLíneasPdf(Venta venta){
        String[] lineasPdf= new String[9];
        lineasPdf[0]="Boleta electrónica - venta Automovil";
        lineasPdf[1]="Automotora Temuco";
        lineasPdf[2]="Fecha: "+venta.getFecha().toString();
        lineasPdf[3]=venta.getCliente().toString();
        lineasPdf[4]="---------------------------------------------------------------------------------------------";
        lineasPdf[5]="Vehiculo comprado";
        lineasPdf[6]=venta.getVehiculo().toString();
        lineasPdf[7]="Valor total con Descuento: "+venta.getCliente().obtenerDescuento()*venta.getVehiculo().getPrecio();
        lineasPdf[8]="Vendedor: "+venta.getVendedor().getNombre();
        return lineasPdf;
    }
    private String generarNombrePdf(Date fecha){
        System.out.println(fecha.toString());
        String fechaArchivo= fecha.toString();
        fechaArchivo=fechaArchivo.replace(" ","").replace(":","");
        String nombreArchivo="target/"+"boleta"+fechaArchivo+".pdf";
        return nombreArchivo;
    }
}