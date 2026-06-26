/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpedidos;

public class validadorCliente {

    public boolean validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: nombre de cliente invalido");
            return false;
        }
        return true;
    }

    public boolean validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("Error: email invalido");
            return false;
        }
        return true;
    }
}
