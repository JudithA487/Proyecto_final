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
public class Universidad {
    // Método que muestra los camiones por universidad
    private static void mostrarCamionesPorUniversidad(String nomusuario, String eleccionuniversidad, String[] universidades) {
        Scanner input = new Scanner(System.in);
        String universidad;
        String mensaje;
        do {
            System.out.println("Introduce las iniciales de la universidad");
            universidad = input.nextLine();
            switch (universidad) {
                case "tec":
                    mensaje = "Circunvalación 2 Baja Mirador\n" +
                            "1.Circunvalación 2 Baja Salle\n" +
                            "2.Mármol - Vistas Cerro Grande\n" +
                            "3.Nombre de Dios Ojo Directo\n" +
                            "4.Nombre de Dios Ojo Inverso\n" +
                            "5.Panamericana San Felipe\n" +
                            "6.Pistolas Meneses AuxiliarA\n" +
                            "7.Pistolas Meneses Auxiliar B\n" +
                            "8.Riberas del Sacramento Directo\n" +
                            "9.Riberas del Sacramento lnverso\n" +
                            "10.Ruta 15 (Fuera de Servicio) Inverso\n" +
                            "11.Ruta 15 (Fuera de Servicio) Directo\n" +
                            "12.Ruta 3 - Granjas Directo\n" +
                            "13.Ruta 3 - Granjas lnverso\n" +
                            "14.Tarahumara Directo\n" +
                            "15.Tarahumara Inverso\n" +
                            "16.Tec Il Colón\n" +
                            "17.Tec ll Industrial";
                    System.out.println("Horarios de los camiones para tec:");
                    for (int i = 1; i <= 17; i++) {
                        System.out.println(i + ": 6:00AM-10:30PM");
                    }
                    break;
                case "tec2":
                    mensaje = "Circunvalación 2 Baja Mirador\n" +
                            "1.Circunvalación 2 Baja Salle\n" +
                            "2.Circunvalación 2 Sube Salle\n" +
                            "3.Circunvalación 2 Sube Mirador\n" +
                            "4.Nombre de Dios Ojo Directo\n" +
                            "5.Pistolas Meneses AuxiliarA\n" +
                            "6.Pistolas Meneses Auxiliar B\n" +
                            "7.Tarahumara Directo\n" +
                            "8.Tarahunmara Inverso ec ll Industrial";
                    System.out.println("Horarios de los camiones para tec2:");
                    for (int i = 1; i <= 8; i++) {
                        System.out.println(i + ": 6:00AM-10:30PM");
                    }
                    break;
                // Agrega los demás casos de universidades aquí
                default:
                    System.out.println("Universidad no reconocida. Inténtalo de nuevo.");
            }
        } while (!universidad.equals("exit"));
    }
    
}
