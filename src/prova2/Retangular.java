package prova2;

public class Retangular implements Formato {
    private final String FORMATO = "retangular";
    private double lado1;
    private double lado2;

    public Retangular(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    private double calculaArea() {
        return this.lado1 * this.lado2;
    }

    @Override
    public String formato() {
        return null;
    }

    @Override
    public double getArea() {
        return this.calculaArea();
    }
}
