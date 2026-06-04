package ejercicioExamen.Main;

import ejercicioExamen.Clases.Jugador;
import ejercicioExamen.Clases.Profesional;
import ejercicioExamen.Clases.Tecnico;
import ejercicioExamen.Enumerado.Posicion;
import ejercicioExamen.Exceptions.PresupuestoExcedidoException;
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
                    contratarTecnico();
                    break;

                case "3":
                    try {
                        despedirProfesional();
                    } catch (ProfesionalNoEncontradoException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case "4":
                    verNominasTotales();
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
        String posOp = sc.nextLine();
        Posicion posicion;
        switch (posOp) {
            case "1":
                posicion = Posicion.PORTERO;
                break;
            case "2":
                posicion = Posicion.DEFENSA;
                break;
            case "3":
                posicion = Posicion.CENTROCAMPISTA;
                break;
            case "4":
                posicion = Posicion.DELANTERO;
                break;
            default:
                System.out.println("Posición inválida, asignando DELANTERO por defecto.");
                posicion = Posicion.DELANTERO;
        }

        try {
            verificarPresupuesto(salarioBase);
            plantilla.add(new Jugador(nombre, salarioBase, posicion));
            System.out.println("Jugador agregado: " + nombre);
        } catch (PresupuestoExcedidoException e) {
            System.out.println("ERROR: " + e.getMessage());

        }
    }

    private static void contratarTecnico() {
        System.out.println("Introduce el nombre del tecnico: ");
        String nombre = sc.nextLine();
        double salario = leerDouble("Salario base: ") + Tecnico.getSalarioBase();
        System.out.println("Puesto (Ejemplo: Médico, Analista): ");
        String puesto = sc.nextLine();

        try{
            verificarPresupuesto(salario);
            plantilla.add(new Tecnico(nombre, salario, puesto));
            System.out.println("Tecnico agregado: " + nombre);
        }catch (PresupuestoExcedidoException e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void despedirProfesional() {
        System.out.println("Introduce el nombre del profesional: ");
        String nombre = sc.nextLine();
        for (Profesional profesional : plantilla){
            if (profesional.getNombre().equals(nombre)){
                plantilla.remove(profesional);
            }else{
                throw new ProfesionalNoEncontradoException("No se ha encontrado al jugador");
            }
        }
    }

    public static void verNominasTotales(){
        if (plantilla.isEmpty()){
            System.out.println("No existe el jugador");
            return;
        }

        System.out.println("\n --- LISTADO DE NÓMINAS ---");
        double gastoTotalClub = 0;

        for ()
    }

    private static void verificarPresupuesto(double nuevoSalarioBase) throws PresupuestoExcedidoException {
        double gastoActual = 0;
        for (Profesional profesional : plantilla) {
            gastoActual += profesional.getSalarioBase();
        }

        if ((gastoActual + nuevoSalarioBase) > PRESUPUESTO_MAXIMO) {
            throw new PresupuestoExcedidoException("El salario base excede el persupuesto máximo.");
        }
    }

    private static double leerDouble (String mensaje){
        while (true){
            try{
                System.out.println(mensaje);
                double valor = Double.parseDouble(sc.nextLine());
                if (valor < 0){
                    throw new NumberFormatException();
                }
                    return valor;
            }catch (NumberFormatException e){
                System.out.println("Introduce un número decimal válido.");
            }
        }
    }
}
