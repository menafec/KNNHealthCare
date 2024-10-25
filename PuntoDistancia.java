public class PuntoDistancia {
    private Punto punto;
    private double distancia;

    public PuntoDistancia(Punto punto, double distancia) {
        this.punto = punto;
        this.distancia = distancia;
    }

    public Punto getPunto() {
        return punto;
    }

    public double getDistancia() {
        return distancia;
    }
}