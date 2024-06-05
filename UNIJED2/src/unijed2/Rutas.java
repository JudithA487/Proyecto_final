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
public class Rutas extends Universidad {
    
     private static void mostrarCamionesPorUniversidad(String nomusuario,String eleccionuniversidad,String[] universidades) {
        Scanner input=new Scanner(System.in);
        String universidad;
        String mensaje;
        boolean verhora;
        do{
        System.out.println("introduce las iniciales de la universidad");
        universidad=input.nextLine();
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
        System.out.println("Informacion del usuario:");
        System.out.println("Nombre de ususario: "+nomusuario);
        System.out.println("Seleccionaste la universidad: "+universidad);
        System.out.println("Camiones para la universidad: "+universidad+( " son:"));
        System.out.println(mensaje);
        
            System.out.println("¿quieres ver los horarios de nuevo?  (true/false)");
            verhora=input.nextBoolean();
            input.nextLine();
            
            
        }while(verhora);
       
    }  
     static void preguntarRutas(Scanner input){
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
}
