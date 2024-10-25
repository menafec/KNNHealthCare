import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KNN {
    private List<Punto> puntosDeEntrenamiento;
    private int k;

    public KNN(List<Punto> puntosDeEntrenamiento, int k) {
        this.puntosDeEntrenamiento = puntosDeEntrenamiento;
        this.k = k;
    }

    // Método para clasificar un nuevo punto
    public String clasificar(Punto nuevoPunto) {
        List<PuntoDistancia> distancias = calcularDistancias(nuevoPunto);
        List<Punto> kVecinos = obtenerKVecinos(distancias);

        // Contar la frecuencia de cada etiqueta (0 o 1)
        int contadorClase0 = 0, contadorClase1 = 0;
        for (Punto vecino : kVecinos) {
            if (vecino.getEtiqueta().equals("0")) {
                contadorClase0++;
            } else if (vecino.getEtiqueta().equals("1")) {
                contadorClase1++;
            }
        }

        // Retornar la etiqueta con mayor frecuencia
        return contadorClase0 > contadorClase1 ? "0" : "1";
    }

    // Método para calcular distancias y retornarlas
    public List<PuntoDistancia> calcularDistancias(Punto nuevoPunto) {
        List<PuntoDistancia> distancias = new ArrayList<>();

        // Calcular la distancia desde el nuevo punto a cada punto de entrenamiento
        for (Punto punto : puntosDeEntrenamiento) {
            double distancia = nuevoPunto.calcularDistancia(punto);
            distancias.add(new PuntoDistancia(punto, distancia));
        }

        // Ordenar por distancia
        Collections.sort(distancias, Comparator.comparingDouble(PuntoDistancia::getDistancia));
        return distancias;
    }

    // Método para obtener los k vecinos más cercanos
    private List<Punto> obtenerKVecinos(List<PuntoDistancia> distancias) {
        List<Punto> kVecinos = new ArrayList<>();
        for (int i = 0; i < k && i < distancias.size(); i++) {
            kVecinos.add(distancias.get(i).getPunto());
        }
        return kVecinos;
    }

    // Método para evaluar el modelo y calcular la precisión
    public double evaluarModelo(List<Punto> conjuntoPrueba) {
        int correctos = 0;

        for (Punto punto : conjuntoPrueba) {
            String prediccion = clasificar(punto);
            if (prediccion.equals(punto.getEtiqueta())) {
                correctos++;
            }
        }

        // Retornar la precisión como un valor entre 0 y 1
        return (double) correctos / conjuntoPrueba.size();
    }
}