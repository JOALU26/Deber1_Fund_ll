/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpedidos;

/**
 *
 * @author USER
 */
public class servicioNotificacion {

    public void enviarConfirmacion(String email,
                                   String nombre, double total) {
        System.out.println("Enviando correo a " + email + "...");
        System.out.println("Asunto: Confirmacion de pedido");
        System.out.println("Cuerpo: Estimado " + nombre
            + ", su pedido por $" + total + " ha sido procesado.");
    }

    public void enviarCancelacion(String email,
                                  String nombre, int idPedido) {
        System.out.println("Enviando correo a " + email + "...");
        System.out.println("Asunto: Cancelacion de pedido");
        System.out.println("Cuerpo: Estimado " + nombre
            + ", su pedido #" + idPedido + " ha sido cancelado.");
    }
  }