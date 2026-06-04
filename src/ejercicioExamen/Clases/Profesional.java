package ejercicioExamen.Clases;
import ejercicioExamen.Interfaces.Bonificacle;


public abstract class Profesional implements Bonificacle {
    private String nombre;
    private static double salarioBase;

    public Profesional(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "nombre='" + nombre + '\'' +
                ", salarioBase=" + salarioBase +
                '}';
    }
}
