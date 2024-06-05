/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unijed2;

import java.util.Scanner;

/**
 *
 * @author acost
 */
public class CamionUniversidad extends Camion {
       private String universidad;

    public CamionUniversidad(String matricula, String modelo) {
        super(matricula, modelo);
        this.universidad = "Sin asignar";
    }

    public void actualizarUniversidad(Scanner scanner) {
        System.out.print("Ingrese la universidad a la que se dirige: ");
        this.universidad = scanner.nextLine();
        System.out.print("Ingrese el nuevo modelo del camión: ");
        this.setModelo(scanner.nextLine());
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Universidad: " + universidad);
    }

    
    
}
