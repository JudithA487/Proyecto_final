/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unijed2;

/**
 *
 * @author acost
 */
public class Chofer extends Usuario{
    private String licenciaConducir;

    public Chofer(String nombreUsuario, String contrasena, String licenciaConducir) {
        super(nombreUsuario, contrasena);
        this.licenciaConducir = licenciaConducir;
    }

    public String getLicenciaConducir() {
        return licenciaConducir;
    }

    @Override
    public String toString() {
        return getNombreUsuario() + "," + getContrasena() + "," + licenciaConducir;
    }
    
    
}
