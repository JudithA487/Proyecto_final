/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unijed2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author acost
 */
public class UNIJED2 {

    /**
     * @param args the command line arguments
     */
    static String[] unisPublicas = {"tec", "tec2", "uach", "upn", "up", "utch", "cam", "cima", "cin", "arqui", "ets", "nsuper", "normal"};
    static String[] unisPrivadas = {"unea", "cdes", "urn", "escograf", "cuc", "tecmilenio", "unidep"};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CamionUniversidad camionUniversidad = new CamionUniversidad("ABC-123", "ModeloX");
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Registrar Chofer");
            System.out.println("3. Iniciar Sesión");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción (1, 2, 3, 4): ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarUsuario(scanner);
                    break;
                case 2:
                    registrarChofer(scanner);
                    break;
                case 3:
                    iniciarSesion(scanner, camionUniversidad);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario user = new Usuario(usuario, contrasena);
        guardarUsuario(user);
    }

    private static void registrarChofer(Scanner scanner) {
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        System.out.print("Ingrese su licencia de conducir: ");
        String licencia = scanner.nextLine();

        Chofer chofer = new Chofer(usuario, contrasena, licencia);
        guardarChofer(chofer);
    }

    private static void guardarUsuario(Usuario usuario) {
        String nombreArchivo = "usuarios.txt";

        if (usuario.getNombreUsuario().isEmpty() || usuario.getContrasena().isEmpty()) {
            System.out.println("Por favor, complete todos los campos.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(usuario.toString());
            writer.newLine();
            System.out.println("Usuario registrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el usuario: " + e.getMessage());
        }
    }

    private static void guardarChofer(Chofer chofer) {
        String nombreArchivo = "choferes.txt";

        if (chofer.getNombreUsuario().isEmpty() || chofer.getContrasena().isEmpty() || chofer.getLicenciaConducir().isEmpty()) {
            System.out.println("Por favor, complete todos los campos.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(chofer.toString());
            writer.newLine();
            System.out.println("Chofer registrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el chofer: " + e.getMessage());
        }
    }

    private static void iniciarSesion(Scanner scanner, CamionUniversidad camionUniversidad) {
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Usuario");
        System.out.println("2. Chofer");
        System.out.print("Ingrese su opción (1 o 2): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (opcion == 1) {
            if (autenticarUsuario(usuario, contrasena)) {
                System.out.println("Inicio de sesión exitoso como Usuario.");
                mostrarOpcionesUsuario(scanner);
            } else {
                System.out.println("Nombre de usuario o contraseña incorrectos.");
            }
        } else if (opcion == 2) {
            if (autenticarChofer(usuario, contrasena)) {
                System.out.println("Inicio de sesión exitoso como Chofer.");
                System.out.println("¿Desea actualizar la universidad a la que se dirige y el modelo del camión? (s/n): ");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("s")) {
                    camionUniversidad.actualizarUniversidad(scanner);
                }
                mostrarOpcionesUsuario(scanner);
            } else {
                System.out.println("Nombre de usuario o contraseña incorrectos.");
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        String nombreArchivo = "usuarios.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    Usuario usuario = new Usuario(partes[0], partes[1]);
                    if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.autenticar(contrasena)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
        return false;
    }

    private static boolean autenticarChofer(String nombreUsuario, String contrasena) {
        String nombreArchivo = "choferes.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    Chofer chofer = new Chofer(partes[0], partes[1], partes[2]);
                    if (chofer.getNombreUsuario().equals(nombreUsuario) && chofer.autenticar(contrasena)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de choferes: " + e.getMessage());
        }
        return false;
    }

    private static void mostrarOpcionesUsuario(Scanner scanner) {
        boolean success = false;
        String eleccionuniversidad = "";

        while (!success) {
            try {
                System.out.println("Por favor, escoge una universidad (unipublic o unipriv):");
                eleccionuniversidad = scanner.nextLine();

                if (eleccionuniversidad.equalsIgnoreCase("unipublic")) {
                    System.out.println("Seleccionaste universidad pública");
                    System.out.println("Instituto Tecnológico de Chihuahua(tec)\n" +
                            "Instituto Tecnológico de Chihuahua II(tec2)\n" +
                            "Universidad Autónoma De Chihuahua(uach)\n" +
                            "Universidad Pedagógica Nacional del Estado de Chihuahua(upn)\n" +
                            "Universidad Politécnica de Chihuahua(up)\n" +
                            "Centro de Actualización del Magisterio de Chihuahua(cam)\n" +
                            "Centro de Investigación en Materiales Avanzados(cima)\n" +
                            "Centro de Investigación y Docencia(cin)\n" +
                            "Escuela de Arquitectura de Chihuahua(arqui)\n" +
                            "Escuela de Trabajo Social del Estado de Chihuahua(ets)\n" +
                            "Escuela Normal Superior Profesor José E. Medrano R.(nsuper)\n" +
                            "Instituto Benemérita y Centenaria Escuela Normal del Estado de Chihuahua, Prof. Luis Urías Belderráin(normal)\n");
                    preguntarRutas(scanner, unisPublicas);
                    success = true;
                } else if (eleccionuniversidad.equalsIgnoreCase("unipriv")) {
                    System.out.println("Seleccionaste universidad privada");
                    System.out.println("(unea)\n" +
                            "CDES(cdes)\n" +
                            "URN(urn)\n" +
                            "Escograf(escograf)\n" +
                            "Claustro universitario de chihuahua(cuc)\n" +
                            "Tecmilenio(tecmilenio)\n" +
                            "UNIDEP(unidep)\n");
                    preguntarRutas(scanner, unisPrivadas);
                    success = true;
                } else {
                    System.out.println("Opción no válida. Debes escoger entre unipriv o unipublic");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

static void preguntarRutas(Scanner scanner, String[] universidades) {
    System.out.println("¿Deseas ver las rutas disponibles? (si/no)");
    String respuesta = scanner.nextLine();
    if (respuesta.equalsIgnoreCase("si")) {
        System.out.println("Seleccione una universidad para ver las rutas:");
        for (int i = 0; i < universidades.length; i++) {
            System.out.println((i + 1) + ". " + universidades[i]);
        }
        int opcion;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
            if (opcion > 0 && opcion <= universidades.length) {
                mostrarCamionesPorUniversidad(universidades[opcion - 1]);
            } else {
                System.out.println("Opción no válida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, introduce un número válido.");
        }
    } else {
        System.out.println("Gracias por usar nuestro servicio.");
    }
}

private static void mostrarCamionesPorUniversidad(String universidad) {
    String mensaje = "";
    boolean verhora;  
        switch(universidad){
            case("tec"):
                mensaje="Circunvalación 2 Baja Mirador\n" +
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
                

                System.out.println("horarios de los camiones para tec: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                System.out.println("7: 6:00AM-10:30PM");
                System.out.println("8: 6:00AM-10:30PM");
                System.out.println("9: 6:00AM-10:30PM");
                System.out.println("10: 6:00AM-10:30PM");
                System.out.println("11: 6:00AM-10:30PM");
                System.out.println("12: 6:00AM-10:30PM");
                System.out.println("13: 6:00AM-10:30PM");
                System.out.println("14: 6:00AM-10:30PM");
                System.out.println("15: 6:00AM-10:30PM");
                System.out.println("16: 6:00AM-10:30PM");
                System.out.println("17: 6:00AM-10:30PM");
        break;
        case"tec2":
            mensaje="Circunvalación 2 Baja Mirador\n" +
            "1.Circunvalación 2 Baja Salle\n" +
            "2.Circunvalación 2 Sube Salle\n" +
            "3.Circunvalación 2 Sube Mirador\n" +
            "4.Nombre de Dios Ojo Directo\n" +
            "5.Pistolas Meneses AuxiliarA\n" +
            "6.Pistolas Meneses Auxiliar B\n" +
            "7.Tarahumara Directo\n" +
            "8.Tarahunmara Inverso ec ll Industrial";
            System.out.println("horarios de los camiones para tec2: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                System.out.println("7: 6:00AM-10:30PM");
                System.out.println("8: 6:00AM-10:30PM");
            break;
            case"uach":
                mensaje="Bowí - ITCH II Circuito Universitario\n" +
                "1.Bowí- UACH II Circuito Universitario\n" +
                "2.Circunvalación 2 Baja Mirador\n" +
                "3.Circunvalación 2 Baja Salle\n" +
                "4.Circunvalación 2 Sube Salle\n" +
                "5.Circunvalación 2 Sube Mirador\n" +
                "6.Pistolas Meneses AuxiliarA\n" +
                "7.Pistolas Meneses Auxiliar B\n" +
                "8.Riberas del Sacramento Directo\n" +
                "9.Riberas del Sacramento Inverso\n" +
                "10.Ruta 100\n" +
                "11.Tec Il Colón\n" +
                "12.Tec Il Industrial";
                System.out.println("horarios de los camiones para uach: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                System.out.println("7: 6:00AM-10:30PM");
                System.out.println("8: 6:00AM-10:30PM");
                System.out.println("9: 6:00AM-10:30PM");
                System.out.println("10: 6:00AM-10:30PM");
                System.out.println("11: 6:00AM-10:30PM");
                System.out.println("12: 6:00AM-10:30PM");
                break;
                case"upn":
                    mensaje="Circunvalación 1 Sube Zarco\n" +
                "1.Mármol - Vistas Cerro Grande\n" +
                "2.Nombre de Dios COjo Directo\n" +
                "3.Nombre de Dios Ojo Inverso\n" +
                "4.Panamericana San Felipe\n" +
                "5.Pistolas Meneses Auxiliar A\n" +
                "6.Pistolas Meneses Auxiliar B\n" +
                "7.Riberas del Sacramento Directo\n" +
                "8.Riberas del Sacramento Inverso\n" +
                "9.Ruta 15 (Fuera de Servicio) Inverso\n" +
                "10.Ruta 15 (Fuera de Servicio) Directo\n" +
                "11.Ruta 3 - Granjas Directo\n" +
                "12.Ruta 3 - Granjas Inverso\n" +
                "13.Tarahumara Directo\n" +
                "14.Tarahumara Inverso\n" +
                "15.Tec Il Colón\n" +
                "16.Tec ll Industrial";
                    System.out.println("horarios de los camiones para upn: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                System.out.println("7: 6:00AM-10:30PM");
                System.out.println("8: 6:00AM-10:30PM");
                System.out.println("9: 6:00AM-10:30PM");
                System.out.println("10: 6:00AM-10:30PM");
                System.out.println("11: 6:00AM-10:30PM");
                System.out.println("12: 6:00AM-10:30PM");
                System.out.println("13: 6:00AM-10:30PM");
                System.out.println("14: 6:00AM-10:30PM");
                System.out.println("15: 6:00AM-10:30PM");
                System.out.println("16: 6:00AM-10:30PM");
                break;
                case"up":
                    mensaje="A. Zarco Martín López";
                    System.out.println("horarios de los camiones para up: ");
                System.out.println("1: 6:00AM-10:30PM");
                    break;
                case"utch":
                    mensaje="Circunvalación 2 Baja Mirador\n" +
                "1.Circunvalación 2 Baja Salle\n" +
                "2.Circunvalación 2 Sube Salle\n" +
                "3.Circunvalación 2 Sube Mirador\n" +
                "4.Panamericana San Felipe\n" +
                "5.Panamericana Mirador eni";
                    System.out.println("horarios de los camiones para utch: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                    break;
                case"cam":
                    mensaje="Circunvalación 2 Baja Mirador\n" +
                "1.Circunvalación 2 Baja Salle\n" +
                "2.Circunvalación 2 Sube Salle\n" +
                "3.Circunvalación 2 Sube Mirador\n" +
                "4.Infonavit Directo\n" +
                "5.Infonavit Inverso\n" +
                "6.Ruta 100";
                    System.out.println("horarios de los camiones para cam: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                    break;
                    case"cin":
                     mensaje="Av. Zarco Esperanza\n" +
                "1.Av. Zarco Martín López\n" +
                "2.Av Zarco Zootecnia\n" +
                "3.Campesina Sector3\n" +
                "4.Campesina Santa Rosa\n" +
                "5.Cerro Bolívar A\n" +
                "6.Cerro Bolívar B\n" +
                "7.Circunvalación 1 Sube Zarco\n" +
                "8.Circunvalación 1 Baja Zarco\n" +
                "9.Circunvalación 2 Baja Mirador\n" +
                "10.Circunvalación 2 Baja Salle\n" +
                "11.Circunvalación 2 Sube Salle\n" +
                "12.Circunvalación 2 Sube Mirador";
                     System.out.println("horarios de los camiones para cin: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                System.out.println("7: 6:00AM-10:30PM");
                System.out.println("8: 6:00AM-10:30PM");
                System.out.println("9: 6:00AM-10:30PM");
                System.out.println("10: 6:00AM-10:30PM");
                System.out.println("11: 6:00AM-10:30PM");
                System.out.println("12: 6:00AM-10:30PM");
                     break;
                     case"arqui":
                         mensaje="Campesina Sector 3\n" +
                "1.Circunvalación 2 Baja Mirador\n" +
                "2.Circunvalación 2 Baja Salle\n" +
                "3.Circunvalación 2 Sube Salle\n" +
                "4.Circunvalación 2 Sube Mirador\n" +
                "5.Dale\n" +
                "6.Dos de Octubre";
                         System.out.println("horarios de los camiones para arqui: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                     break;
                     case"ets":
                         mensaje="Campesina Sector 3\n" +
                "1.Circunvalación 2 Baja Mirador\n" +
                "2.Circunvalación 2 Baja Salle\n" +
                "3.Circunvalación 2 Sube Salle\n" +
                "4.Circunvalación 2 Sube Mirador\n" +
                "5.Dale\n" +
                "6.Dos de Octubre";
                         System.out.println("horarios de los camiones para ets: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                     break;
                     case"nsuper":
                         mensaje="Dale";
                         System.out.println("horarios de los camiones para Dale: ");
                System.out.println("1: 6:00AM-10:30PM");
                         break;
                         case"normal":
                             mensaje="Circunvalación 1 Sube Zarco\n" +
                "1.Circunvalación 2 Baja Mirador\n" +
                "2.Circunvalación 2 Baja Salle\n" +
                "3.Circunvalación 2 Sube Sale\n" +
                "4.Circunvalación 2 Sube Mirador\n" +
                "5.Tec ll Colón\n" +
                "6.Tec ll Industrial";
                             System.out.println("horarios de los camiones para normal: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                break;
                case"unea":
                    mensaje="1. Pistolas Meneses Auxiliar A\n" +
                "2. Pistolas Meneses Auxiliar B\n" +
                "3. Riberas del Sacramento Directo\n" +
                "4. Riberas del Sacramento Inverso";
                    System.out.println("horarios de los camiones para unea: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                    break;
                    case"cdes":
                        mensaje="1. Chihuahua Fco. Portillo Directo\n" +
                "2. Chihuahua Fco. Portillo Inverso-Laderas\n" +
                "3. Chihuahua Fco. Portillo Inverso - Vistas Circunvalación\n" +
                "4. 1 Sube Zarco Circunvalación\n" +
                "5. 2 Sube Salle Circunvalación\n" +
                "6. 2 Sube Mirador Dale\n" +
                "7. Dos de Octubre Jardines de Oriente\n" +
                "8. Komatsu Directo\n" +
                "9. Komatsu Inverso\n" +
                "10. Mármol - Vistas Cerro Grande\n" +
                "11. Nombre de Dios Ojo Directo\n" +
                "12. Nombre de Dios Ojo Inverso\n" +
                "13. Panamericana San Felipe\n" +
                "14. Pistolas Meneses Auxiliar A\n" +
                "15. Pistolas Meneses Auxiliar B\n" +
                "16. Punta Oriente\n" +
                "17. Ramiro Valles Concordia\n" +
                "18. Riberas del Sacramento Directo\n" +
                "19. Riberas del Sacramento Inverso\n" +
                "20. Rosario Arquitectos\n" +
                "21. Ruta 15 Directo\n" +
                "22. Ruta 15 Inverso\n" +
                "23. Ruta 3- Granjas Directo\n" +
                "24. Ruta 3 - Granjas Inverso\n" +
                "25. Sierra Azul\n" +
                "26. Tarahumara Directo\n" +
                "27. Tarahumara Inverso\n" +
                "28. Tec Il Colón\n" +
                "29. Tec ll Industrial\n" +
                "30. Villa Juárez Kennedy";
                        System.out.println("horarios de los camiones para cdes: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                System.out.println("7: 6:00AM-10:30PM");
                System.out.println("8: 6:00AM-10:30PM");
                System.out.println("9: 6:00AM-10:30PM");
                System.out.println("10: 6:00AM-10:30PM");
                System.out.println("11: 6:00AM-10:30PM");
                System.out.println("12: 6:00AM-10:30PM");
                System.out.println("13: 6:00AM-10:30PM");
                System.out.println("14: 6:00AM-10:30PM");
                System.out.println("15: 6:00AM-10:30PM");
                System.out.println("16: 6:00AM-10:30PM");
                System.out.println("17: 6:00AM-10:30PM");
                System.out.println("18: 6:00AM-10:30PM");
                System.out.println("19: 6:00AM-10:30PM");
                System.out.println("20: 6:00AM-10:30PM");
                System.out.println("21: 6:00AM-10:30PM");
                System.out.println("22: 6:00AM-10:30PM");
                System.out.println("23: 6:00AM-10:30PM");
                System.out.println("24: 6:00AM-10:30PM");
                System.out.println("25: 6:00AM-10:30PM");
                System.out.println("26: 6:00AM-10:30PM");
                System.out.println("27: 6:00AM-10:30PM");
                System.out.println("28: 6:00AM-10:30PM");
                System.out.println("29: 6:00AM-10:30PM");
                System.out.println("30: 6:00AM-10:30PM");
               break;
               case"urn":
                   mensaje="1. Av. Zarco Esperanza\n" +
                "2. Av. Zarco Martín López\n" +
                "3. Av. Zarco Zootecnia\n" +
                "4. Campesina Sector 3\n" +
                "5. Campesina Santa Rosa\n" +
                "6. Cerro Bolívar A\n" +
                "7. Cerro Bolívar B\n" +
                "8. Une Presa El Tintero\n" +
                "9. Circunvalación 1 Sube Zarco\n" +
                "10. Circunvalación 1 Baja Zarco\n" +
                "11. Circunvalación 2 Baja Mirador\n" +
                "12. Circunvalación 2 Baja Salle\n" +
                "13. Circunvalación 2 Sube Salle\n" +
                "14. Circunvalación 2 Sube Mirador\n" +
                "15. Ramiro Valles Concordia";
                   System.out.println("horarios de los camiones para urn: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                System.out.println("7: 6:00AM-10:30PM");
                System.out.println("8: 6:00AM-10:30PM");
                System.out.println("9: 6:00AM-10:30PM");
                System.out.println("10: 6:00AM-10:30PM");
                System.out.println("11: 6:00AM-10:30PM");
                System.out.println("12: 6:00AM-10:30PM");
                System.out.println("13: 6:00AM-10:30PM");
                System.out.println("14: 6:00AM-10:30PM");
                System.out.println("15: 6:00AM-10:30PM");
                break;
                case"escograf":
                    mensaje="1. Cerro Bolívar A\n" +
                "2. Cerro Bolívar B\n" +
                "3. Mármol- Vistas Cerro Grande\n" +
                "4. Nombre de Dios Ojo Directo\n" +
                "5. Nombre de Dios Ojo Inverso\n" +
                "6. Panamericana San Felipe\n" +
                "7. Pistolas Meneses Auxiliar A\n" +
                "8. Pistolas Meneses Auxiliar B\n" +
                "9. Riberas del Sacramento Directo\n" +
                "10. Riberas del Sacramento Inverso\n" +
                "11. Ruta 15 Directo\n" +
                "12. Ruta 15 Inverso\n" +
                "13. Ruta 3 - Granjas Directo\n" +
                "14. Ruta 3 - Granjas Inverso\n" +
                "15. Tarahumara Directo\n" +
                "16. Tarahumara Inverso\n" +
                "17. Tec ll Colón\n" +
                "18. Tec ll Industrial";
                    System.out.println("horarios de los camiones para escograf: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                System.out.println("7: 6:00AM-10:30PM");
                System.out.println("8: 6:00AM-10:30PM");
                System.out.println("9: 6:00AM-10:30PM");
                System.out.println("10: 6:00AM-10:30PM");
                System.out.println("11: 6:00AM-10:30PM");
                System.out.println("12: 6:00AM-10:30PM");
                System.out.println("13: 6:00AM-10:30PM");
                System.out.println("14: 6:00AM-10:30PM");
                System.out.println("15: 6:00AM-10:30PM");
                System.out.println("16: 6:00AM-10:30PM");
                System.out.println("17: 6:00AM-10:30PM");
                System.out.println("18: 6:00AM-10:30PM");
                break;
                case"cuc":
                   mensaje="1. Cerro Bolívar A\n" +
                "2. Cerro Bolívar B\n" +
                "3. Mármol- Vistas Cerro Grande\n" +
                "4. Nombre de Dios Ojo Directo\n" +
                "5. Nombre de Dios Ojo Inverso\n" +
                "6. Panamericana San Felipe\n" +
                "7. Pistolas Meneses Auxiliar A\n" +
                "8. Pistolas Meneses Auxiliar B\n" +
                "9. Riberas del Sacramento Directo\n" +
                "10. Riberas del Sacramento Inverso\n" +
                "11. Ruta 15 Directo\n" +
                "12. Ruta 15 Inverso\n" +
                "13. Ruta 3 - Granjas Directo\n" +
                "14. Ruta 3 - Granjas Inverso\n" +
                "15. Tarahumara Directo\n" +
                "16. Tarahumara Inverso\n" +
                "17. Tec ll Colón\n" +
                "18. Tec ll Industrial";
                   System.out.println("horarios de los camiones para cuc: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                System.out.println("7: 6:00AM-10:30PM");
                System.out.println("8: 6:00AM-10:30PM");
                System.out.println("9: 6:00AM-10:30PM");
                System.out.println("10: 6:00AM-10:30PM");
                System.out.println("11: 6:00AM-10:30PM");
                System.out.println("12: 6:00AM-10:30PM");
                System.out.println("13: 6:00AM-10:30PM");
                System.out.println("14: 6:00AM-10:30PM");
                System.out.println("15: 6:00AM-10:30PM");
                System.out.println("16: 6:00AM-10:30PM");
                System.out.println("17: 6:00AM-10:30PM");
                break;
                case"tecmilenio":
                   mensaje= "1. Av. Zarco Esperanza\n" +
                "2. Av. Zarco Martín López\n" +
                "3. Av. Zarco Zootecnia\n" +
                "4. Camino Real\n" +
                "5. Campesina Sector 3\n" +
                "6. Campesina Santa Rosa\n" +
                "7. Cerro Bolívar A\n" +
                "8. Cerro Bolívar B\n" +
                "9. Chihuahua Fco. Portillo Directo\n" +
                "10. Chihuahua Fco. Portillo Inverso - Laderas\n" +
                "11. Chihuahua Fco. Portillo Inverso - Vistas\n" +
                "12. Circunvalación 1 Sube Zarco\n" +
                "13. Circunvalación 1 Baja Zarco\n" +
                "14. Circunvalación 2 Baja Mirador\n" +
                "15. Circunvalación 2 Baja Salle\n" +
                "16. Circunvalación 2 Sube Salle\n" +
                "17. Circunvalación 2 Sube Mirador\n" +
                "18. Dale Dos de Octubre Jardines de Oriente\n" +
                "19. Komatsu Directo\n" +
                "20. Komatsu Inverso\n" +
                "21. Mármol - Vistas Cerro Grande\n" +
                "22. Nombre de Dios Ojo Directo\n" +
                "23. Nombre de Dios Ojo Inverso\n" +
                "24. Panamericana San Felipe\n" +
                "25. Panamericana Mirador\n" +
                "26. Punta Oriente\n" +
                "27. Ramiro Valles Concordia\n" +
                "28. Riberas del Sacramento Directo\n" +
                "29. Riberas del Sacramento Inverso\n" +
                "30. Rosario Arquitectos\n" +
                "31. Ruta 15 Directo\n" +
                "32. Ruta 15 Inverso\n" +
                "33. Ruta 3- Granjas Directo\n" +
                "34. Ruta 3- Granjas Inverso\n" +
                "35. Sierra Azul\n" +
                "36. Tarahumara Directo\n" +
                "37. Tarahumara Inverso\n" +
                "38. Tec Il Colón\n" +
                "39. Tec Il Industrial\n" +
                "40. Villa Juárez Kennedy\n" +
                "41. Villas del Prado\n" +
                "42. Urbi Avalos\n" +
                "43. Plan de Ayala";
                System.out.println("horarios de los camiones para tecmilenio: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                System.out.println("7: 6:00AM-10:30PM");
                System.out.println("8: 6:00AM-10:30PM");
                System.out.println("9: 6:00AM-10:30PM");
                System.out.println("10: 6:00AM-10:30PM");
                System.out.println("11: 6:00AM-10:30PM");
                System.out.println("12: 6:00AM-10:30PM");
                System.out.println("13: 6:00AM-10:30PM");
                System.out.println("14: 6:00AM-10:30PM");
                System.out.println("15: 6:00AM-10:30PM");
                System.out.println("16: 6:00AM-10:30PM");
                System.out.println("17: 6:00AM-10:30PM");
                System.out.println("18: 6:00AM-10:30PM");
                System.out.println("19: 6:00AM-10:30PM");
                System.out.println("20: 6:00AM-10:30PM");
                System.out.println("21: 6:00AM-10:30PM");
                System.out.println("22: 6:00AM-10:30PM");
                System.out.println("23: 6:00AM-10:30PM");
                System.out.println("24: 6:00AM-10:30PM");
                System.out.println("25: 6:00AM-10:30PM");
                System.out.println("26: 6:00AM-10:30PM");
                System.out.println("27: 6:00AM-10:30PM");
                System.out.println("28: 6:00AM-10:30PM");
                System.out.println("29: 6:00AM-10:30PM");
                System.out.println("30: 6:00AM-10:30PM");
                System.out.println("31: 6:00AM-10:30PM");
                System.out.println("32: 6:00AM-10:30PM");
                System.out.println("33: 6:00AM-10:30PM");
                System.out.println("34: 6:00AM-10:30PM");
                System.out.println("35: 6:00AM-10:30PM");
                System.out.println("36: 6:00AM-10:30PM");
                System.out.println("37: 6:00AM-10:30PM");
                System.out.println("38: 6:00AM-10:30PM");
                System.out.println("39: 6:00AM-10:30PM");
                System.out.println("40: 6:00AM-10:30PM");
                System.out.println("41: 6:00AM-10:30PM");
                System.out.println("42: 6:00AM-10:30PM");
                System.out.println("43: 6:00AM-10:30PM");
            break;
            case"unidep":
                 mensaje="1. Cerro Bolívar B\n" +
                "2. Circunvalación 1 Sube Zarco\n" +
                "3. Circunvalación 1 Baja Zarco\n" +
                "4. Circunvalación 2 Baja Mirador\n" +
                "5. Circunvalación 2 Sube Mirador\n" +
                "6. Panamericana San Felipe\n" +
                "7. Panamericana Mirador";
                System.out.println("horarios de los camiones para unidep: ");
                System.out.println("1: 6:00AM-10:30PM");
                System.out.println("2: 6:00AM-10:30PM");
                System.out.println("3: 6:00AM-10:30PM");
                System.out.println("4: 6:00AM-10:30PM");
                System.out.println("5: 6:00AM-10:30PM");
                System.out.println("6: 6:00AM-10:30PM");
                System.out.println("7: 6:00AM-10:30PM");
                 break;
            default:
                mensaje="Universidad no reconocida";
        }
        System.out.println("Rutas para " + universidad + " son:");
        System.out.println(mensaje);
}
        static void preguntarRutas1(Scanner input){
            System.out.println("quieres ver las rutas de los camiones?(true, false)");
            boolean verRutas=input.nextBoolean();
            input.nextLine();
            if(verRutas){
                System.out.println("introduce el numero del camion que deseas ver:");
                int numeroCamion=input.nextInt();
                input.nextLine();
                System.out.println("rutas del camion "+ numeroCamion+":");
                 int Circunvalación2 = 0;
        int Mármol = 0;
        int NombredeDios = 0;
        int PanamericanaSanFelipe = 0;
        int PistolasMenesesAuxiliar = 0;
        int RiberasdelSacramento = 0;
        int Ruta15 = 0;
        int Ruta3 = 0;
        int Tarahumara = 0;
        int tec2 = 0;
         for (int i = Circunvalación2; i <= Circunvalación2; i++) {
            System.out.println("RUTAS");
            System.out.println("Calle Tabasco");
            System.out.println("Lateral SAcramento");
            System.out.println("Calle Río San Pedro");
            System.out.println("Calle Río Nazas");
            System.out.println("Río San Juan");
            System.out.println("Río Urique");
            System.out.println("Río Pánuco");
            System.out.println("Río Florido");
            System.out.println("Av. H. Colegio Militar");
            System.out.println("General Manuel Rincón");
        }
        for (int i = Mármol; i <= Mármol; i++) {
            System.out.println("RUTAS");
            System.out.println("De los Eucaliptos");
            System.out.println("Calle 68");
            System.out.println("Calle Puerto Benito Juárez");
            System.out.println("Calle Puerto Progreso");
            System.out.println("Privada Sec. De La Marina");
            System.out.println("Av. Nueva España");
            System.out.println("Al Super");
            System.out.println("Periférico Francisco R. Almada");
            System.out.println("Calle Pánfilo De Narvaéz");
            System.out.println("Misión De Santa Bárbara");
        }
        for (int i = NombredeDios; i <= NombredeDios; i++) {
            System.out.println("RUTAS");
            System.out.println("Av. colón");
            System.out.println("J. Eligio Muñoz");
            System.out.println("Av. tecnologico");
            System.out.println("Fisioquímica");
            System.out.println("Mercurio");
            System.out.println("23 De Septiembre");
            System.out.println("Calle Jóvenes Vanguardias");
            System.out.println("Martires Agraristas");
            System.out.println("Columbus");
            System.out.println("Calle 16 De Septiembre");
        }
        for (int i = PanamericanaSanFelipe; i <= PanamericanaSanFelipe; i++) {
            System.out.println("RUTAS");
            System.out.println("Boulevard Gustavo Días Ordaz");
            System.out.println("Calle Guadalupe Victoria");
            System.out.println("Av. Cuauhtémoc");
            System.out.println("Av. Cristobal Colón");
            System.out.println("Av. Prolongación Teófilo Borunda");
            System.out.println("Av. Mirador");
            System.out.println("Berna");
            System.out.println("O'Higgins");
            System.out.println("Ankara");
            System.out.println("José de San Martin");
        }
        for (int i = PistolasMenesesAuxiliar; i <= PistolasMenesesAuxiliar; i++) {
            System.out.println("RUTAS");
            System.out.println("Central terminal vivebus norte");
            System.out.println("Vivebus terminal norte");
            System.out.println("Av. tecnologico");
            System.out.println("Av. Cristobal Colón");
            System.out.println("Av. Miguel de Cervantes Saavedra");
            System.out.println("León Tolstoi");
            System.out.println("Av. Fedor Dostoyevzki");
            System.out.println("Martin H. Barrios Álvarez");
            System.out.println("Joaquín Pedrero");
            System.out.println("Antonio Rullan Ferrer");
        }
         for (int i = RiberasdelSacramento; i <= RiberasdelSacramento; i++) {
            System.out.println("RUTAS");
            System.out.println("Central terminal vivebus norte");
            System.out.println("Vivebus terminal norte");
            System.out.println("Av. tecnologico");
            System.out.println("Av. Cristobal Colón");
            System.out.println("Av. Miguel de Cervantes Saavedra");
            System.out.println("León Tolstoi");
            System.out.println("Av. Fedor Dostoyevzki");
            System.out.println("Martin H. Barrios Álvarez");
            System.out.println("Joaquín Pedrero");
            System.out.println("Antonio Rullan Ferrer");
        }
        for (int i = Ruta15; i <= Ruta15; i++) {
            System.out.println("RUTAS");
            System.out.println("Central terminal vivebus norte");
            System.out.println("Vivebus terminal norte");
            System.out.println("Av. tecnologico");
            System.out.println("Av. Cristobal Colón");
            System.out.println("Av. Miguel de Cervantes Saavedra");
            System.out.println("León Tolstoi");
            System.out.println("Av. Fedor Dostoyevzki");
            System.out.println("Martin H. Barrios Álvarez");
            System.out.println("Joaquín Pedrero");
            System.out.println("Antonio Rullan Ferrer");
        }
        for (int i = Ruta3; i <= Ruta3; i++) {
            System.out.println("RUTAS");
            System.out.println("Central terminal vivebus norte");
            System.out.println("Vivebus terminal norte");
            System.out.println("Av. tecnologico");
            System.out.println("Av. Cristobal Colón");
            System.out.println("Av. Miguel de Cervantes Saavedra");
            System.out.println("León Tolstoi");
            System.out.println("Av. Fedor Dostoyevzki");
            System.out.println("Martin H. Barrios Álvarez");
            System.out.println("Joaquín Pedrero");
            System.out.println("Antonio Rullan Ferrer");
        }
        for (int i = Tarahumara; i <= Tarahumara; i++) {
            System.out.println("RUTAS");
            System.out.println("Central terminal vivebus norte");
            System.out.println("Vivebus terminal norte");
            System.out.println("Av. tecnologico");
            System.out.println("Av. Cristobal Colón");
            System.out.println("Av. Miguel de Cervantes Saavedra");
            System.out.println("León Tolstoi");
            System.out.println("Av. Fedor Dostoyevzki");
            System.out.println("Martin H. Barrios Álvarez");
            System.out.println("Joaquín Pedrero");
            System.out.println("Antonio Rullan Ferrer");
        }
        for (int i = tec2; i <= tec2; i++) {
            System.out.println("RUTAS");
            System.out.println("Central terminal vivebus norte");
            System.out.println("Vivebus terminal norte");
            System.out.println("Av. tecnologico");
            System.out.println("Av. Cristobal Colón");
            System.out.println("Av. Miguel de Cervantes Saavedra");
            System.out.println("León Tolstoi");
            System.out.println("Av. Fedor Dostoyevzki");
            System.out.println("Martin H. Barrios Álvarez");
            System.out.println("Joaquín Pedrero");
            System.out.println("Antonio Rullan Ferrer");
        }

            }
     
    

}

      

    private static void mostrarOpcionesChofer(Scanner scanner, CamionUniversidad camionUniversidad) {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Actualizar Universidad");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opción (1 o 2): ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    camionUniversidad.actualizarUniversidad(scanner);
                    camionUniversidad.mostrarDetalles();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    }

    

