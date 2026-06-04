package ejercicioExamen.Main;

import ejercicioExamen.Clases.Jugador;
import ejercicioExamen.Clases.Profesional;
import ejercicioExamen.Enumerado.Posicion;
import ejercicioExamen.Exceptions.ProfesionalNoEncontradoException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final double PRESUPUESTO_MAXIMO = 10000;

    private static final ArrayList<Profesional> plantilla = new ArrayList();
    private static final Scanner sc = new Scanner(System.in);

    static void main() {

        while (true) {
            System.out.println("\n--------GESTIÓN DEL CLUB--------");
            System.out.println("1. Contratar jugador");
            System.out.println("2. Contratar Cuerpo Técnico");
            System.out.println("3. Despedir Profesional");
            System.out.println("4. Ver nóminas totales");
            System.out.println("5. Salir");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    contratarJugador();
                    break;

                case "2":
                    //contratarTecnico();
                    break;

                case "3":
                    try {
                        //despedirProfesional();
                    } catch (ProfesionalNoEncontradoException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case "4":
                    //verNominasTotales();
                    break;

                case "5":
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida, intentalo de nuevo");
            }
        }
    }

    private static void contratarJugador() {
        System.out.println("Introduce el nombre del jugador: ");
        String nombre = sc.nextLine();
        double salarioBase = Double.parseDouble(("Salario base: ") + Jugador.getSalarioBase());

        System.out.println("POSICIONES: 1. PORTERO 2. DEFENSA 3. CENTROCAMPISTA 4. DELANTERO");
        String posOp =  sc.nextLine();
        Posicion posicion;
        switch (posOp) {
            case "1": posicion  = Posicion.PORTERO; break;
            case "2": posicion  = Posicion.DEFENSA; break;
            case "3": posicion  = Posicion.CENTROCAMPISTA; break;
            case "4": posicion  = Posicion.DELANTERO; break;

        }
    }
}
