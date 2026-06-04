package ejercicioExamen.Clases;

import ejercicioExamen.Enumerado.Posicion;

public class Jugador extends Profesional {
    private Posicion posicion;

    public Jugador(String nombre, double salarioBase, Posicion posicion) {
        super(nombre, salarioBase);
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "posicion=" + posicion +
                '}';
    }

    @Override
    public double calcularPlusSalarial() {
        return getSalarioBase() * 0.10;
    }
}
