package prova2;

public class Circular implements Formato {

    private double raio;
    private final String FORMATO = "circular";
    private final int ELEVAR_QUADRADO = 2;

    public Circular(double raio) {
        this.raio = raio;
    }

    private double calculaArea() {
        return Math.pow(raio, ELEVAR_QUADRADO) * Math.PI;
    }

    @Override
    public String formato() {
        return this.FORMATO;
    }

    @Override
    public double getArea() {
        return calculaArea();
    }
}
