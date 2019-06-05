package prova2;

public class Pentagonal implements Formato {

    private final String FORMATO = "pentagonal";
    private double lado;
    private double altura;

    public Pentagonal(double lado) {
        this.lado = lado;
        calculaAltura();
    }

    private void calculaAltura() {
        this.altura = (this.lado / 2 * Math.sqrt(5) + 2 * Math.sqrt(5) ) / 2;
    }

    private double calculaArea() {
        return 5.0 * (this.lado * this.altura) / 2.0;
    }

    @Override
    public String formato() {
        return this.FORMATO;
    }

    @Override
    public double getArea() {
        return this.calculaArea();
    }
}
