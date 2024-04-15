package modelo;

public class Lavadora extends Electrodomestico {
	
    // atributos
    private double carga;
    private static final double CARGA_POR_DEFECTO = 5;

    // constructores
    public Lavadora() {
        super();
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(double carga, double precioBase, String color, char consumoEnergetico, double peso) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    // metodos
    public double getCarga() {
        return carga;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (this.carga > 30) {
            precioFinal += 50;
        }

        return precioFinal;
    }
}

