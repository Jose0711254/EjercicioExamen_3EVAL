package ejercicioExamen.Clases;

import ejercicioExamen.Interfaces.Bonificacle;

public class Tecnico extends Profesional implements Bonificacle {
    private String puesto;

    public Tecnico(String nombre, double salarioBase, String puesto) {
        super(nombre, salarioBase);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public double calcularPlusSalarial(){
        return 200.0;
    }
}