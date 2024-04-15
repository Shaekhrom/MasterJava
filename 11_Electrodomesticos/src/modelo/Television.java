package modelo;

public class Television extends Electrodomestico {
    // atributos
    private int resolucion; 
    private boolean sintonizadorTDT;
    private static final int RESOLUCION_POR_DEFECTO = 20;
    private static final boolean SINTONIZADOR_TDT_POR_DEFECTO = false;

    // constructores
    public Television() {
        super();
        this.resolucion = RESOLUCION_POR_DEFECTO;
        this.sintonizadorTDT = SINTONIZADOR_TDT_POR_DEFECTO;
    }

    public Television(double precioBase, double peso) {
        super(precioBase, peso);
        this.resolucion = RESOLUCION_POR_DEFECTO;
        this.sintonizadorTDT = SINTONIZADOR_TDT_POR_DEFECTO;
    }

    public Television(int resolucion, boolean sintonizadorTDT, double precioBase, String color, char consumoEnergetico, double peso) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    // metodos
    public int getResolucion() {
        return resolucion;
    }

    public boolean getSintonizadorTDT() {
        return sintonizadorTDT;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (this.resolucion > 40) {
            precioFinal *= 1.3; 
        }

        if (this.sintonizadorTDT) {
            precioFinal += 50;
        }

        return precioFinal;
    }
}

