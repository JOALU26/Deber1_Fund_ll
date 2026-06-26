/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpedidos;

import java.sql.*;
import java.util.List;

public class generadorPedidos {

    private final Connection conexionBD;
    private final validadorCliente validador;
    private final calculadoraPrecios calculador;
    private final generadorFactura generadorFactura;
    private final servicioNotificacion notificacion;
    private final estrategiaDescuento estrategiaDescuento;

    // DIP: las dependencias se inyectan desde afuera
    public generadorPedidos(Connection conexionBD,
                         estrategiaDescuento estrategiaDescuento) {
        this.conexionBD          = conexionBD;
        this.estrategiaDescuento = estrategiaDescuento;
        this.validador           = new validadorCliente();
        this.calculador          = new calculadoraPrecios();
        this.generadorFactura    = new generadorFactura();
        this.notificacion        = new servicioNotificacion();
    }

    public void procesarPedido(String nombre, String email,
                               List<String> productos,
                               List<Double> precios,
                               List<Integer> cantidades) {
        if (!validador.validarNombre(nombre)) return;
        if (!validador.validarEmail(email)) return;

        double subtotal  = calculador.calcularSubtotal(precios, cantidades);
        double descuento = estrategiaDescuento.aplicar(subtotal);
        double impuesto  = calculador.calcularImpuesto(subtotal, descuento);
        double total     = calculador.calcularTotal(subtotal,
                                                    descuento, impuesto);

        guardarEnBD(nombre, total);
        generadorFactura.generar(nombre, productos, precios,
                                 cantidades, subtotal,
                                 descuento, impuesto, total);
        notificacion.enviarConfirmacion(email, nombre, total);
        System.out.println("[LOG] Pedido procesado para "
                           + nombre + " - Total: " + total);
    }

    public void cancelarPedido(String nombre,
                               String email, int idPedido) {
        if (!validador.validarNombre(nombre)) return;
        if (!validador.validarEmail(email)) return;

        try {
            Statement stmt = conexionBD.createStatement();
            stmt.executeUpdate("DELETE FROM pedidos WHERE id = " + idPedido);
        } catch (SQLException e) {
            System.out.println("Error al cancelar: " + e.getMessage());
        }
        notificacion.enviarCancelacion(email, nombre, idPedido);
    }

    private void guardarEnBD(String nombre, double total) {
        try {
            Statement stmt = conexionBD.createStatement();
            String sql = "INSERT INTO pedidos (cliente, total) VALUES ('"
                         + nombre + "', " + total + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}
