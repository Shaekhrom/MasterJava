package modelo;

public class Electrodomestico {
	
    // atributos
    private double precioBase;
    private String color;
    private char consumoEnergetico;
    private double peso;

    // constantes
    private static final String[] COLORES_DISPONIBLES = {"blanco", "negro", "rojo", "azul", "gris"};
    private static final char CONSUMO_ENERGETICO_POR_DEFECTO = 'F';
    private static final String COLOR_POR_DEFECTO = "blanco";
    private static final double PRECIO_BASE_POR_DEFECTO = 100;
    private static final double PESO_POR_DEFECTO = 5;

    // constructores
    public Electrodomestico() {
        this.precioBase = PRECIO_BASE_POR_DEFECTO;
        this.color = COLOR_POR_DEFECTO;
        this.consumoEnergetico = CONSUMO_ENERGETICO_POR_DEFECTO;
        this.peso = PESO_POR_DEFECTO;
    }

    public Electrodomestico(double precioBase, double peso) {
        this();
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this(precioBase, peso);
        comprobarColor(color);
        comprobarConsumoEnergetico(consumoEnergetico);
    }

    // metodos
    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    private void comprobarConsumoEnergetico(char letra) {
        if (letra >= 'A' && letra <= 'F') {
            this.consumoEnergetico = letra;
        } else {
            this.consumoEnergetico = CONSUMO_ENERGETICO_POR_DEFECTO;
        }
    }

    private void comprobarColor(String color) {
        boolean encontrado = false;
        for (String colorDisponible : COLORES_DISPONIBLES) {
            if (colorDisponible.equalsIgnoreCase(color)) {
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            this.color = COLOR_POR_DEFECTO;
        } else {
            this.color = color;
        }
    }

    public double precioFinal() {
        double precioFinal = this.precioBase;

        switch (this.consumoEnergetico) {
            case 'A':
                precioFinal += 100;
                break;
            case 'B':
                precioFinal += 80;
                break;
            case 'C':
                precioFinal += 60;
                break;
            case 'D':
                precioFinal += 50;
                break;
            case 'E':
                precioFinal += 30;
                break;
            case 'F':
                precioFinal += 10;
                break;
        }

        if (this.peso >= 0 && this.peso < 20) {
            precioFinal += 10;
        } else if (this.peso >= 20 && this.peso < 50) {
            precioFinal += 50;
        } else if (this.peso >= 50 && this.peso < 80) {
            precioFinal += 80;
        } else if (this.peso >= 80) {
            precioFinal += 100;
        }

        return precioFinal;
    }
}

