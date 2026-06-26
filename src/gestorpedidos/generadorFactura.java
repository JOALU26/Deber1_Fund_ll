/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpedidos;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author USER
 */
public class generadorFactura {

    public void generar(String nombreCliente,
                        List<String> productos,
                        List<Double> precios,
                        List<Integer> cantidades,
                        double subtotal, double descuento,
                        double impuesto, double total) {
        try {
            FileWriter writer = new FileWriter(
                                "factura_" + nombreCliente + ".txt");
            writer.write("FACTURA\n");
            writer.write("Cliente: " + nombreCliente + "\n");
            for (int i = 0; i < productos.size(); i++) {
                writer.write(productos.get(i) + " x" + cantidades.get(i)
                    + " = $" + (precios.get(i) * cantidades.get(i)) + "\n");
            }
            writer.write("Subtotal: $" + subtotal + "\n");
            writer.write("Descuento: $" + descuento + "\n");
            writer.write("Impuesto: $" + impuesto + "\n");
            writer.write("TOTAL: $" + total + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al generar factura: " + e.getMessage());
        }
    }
}
