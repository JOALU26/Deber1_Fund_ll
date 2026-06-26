/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpedidos;
import java.util.List;
/**
 *
 * @author USER
 */
public class calculadoraPrecios {

    public double calcularSubtotal(List<Double> precios,
                                   List<Integer> cantidades) {
        double subtotal = 0;
        for (int i = 0; i < precios.size(); i++) {
            subtotal += precios.get(i) * cantidades.get(i);
        }
        return subtotal;
    }

    public double calcularImpuesto(double subtotal, double descuento) {
        return (subtotal - descuento) * 0.12;
    }

    public double calcularTotal(double subtotal,
                                double descuento, double impuesto) {
        return subtotal - descuento + impuesto;
    }
}
