/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpedidos;

/**
 *
 * @author USER
 */
public class descuentoFrecuente implements estrategiaDescuento {
    public double aplicar(double subtotal) { return subtotal * 0.10; }
}
