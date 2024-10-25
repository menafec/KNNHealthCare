import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Punto> puntosDeEntrenamiento = new ArrayList<>();

        // Leer el archivo CSV
        String csvFile = "health care diabetes.csv"; // Asegúrate de que la ruta sea correcta
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Saltar la cabecera
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(csvSplitBy);
                // Asegúrate de convertir los datos a los tipos correctos
                double pregnancies = Double.parseDouble(datos[0]);
                double glucose = Double.parseDouble(datos[1]);
                double bloodPressure = Double.parseDouble(datos[2]);
                double skinThickness = Double.parseDouble(datos[3]);
                double insulin = Double.parseDouble(datos[4]);
                double bmi = Double.parseDouble(datos[5]);
                double diabetesPedigreeFunction = Double.parseDouble(datos[6]);
                double age = Double.parseDouble(datos[7]);
                String outcome = datos[8]; // 0 o 1 como String

                // Crear un nuevo Punto y añadirlo a la lista
                puntosDeEntrenamiento.add(new Punto(pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age, outcome));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear el clasificador KNN con k = 5
        KNN knn = new KNN(puntosDeEntrenamiento, 5);

        // Clasificar un nuevo punto (ajusta los valores según desees probar)
        Punto nuevoPunto = new Punto(2, 130, 70, 0, 0, 28, 0.3, 40, null); // Ajusta este valor según sea necesario
        String clasePredicha = knn.clasificar(nuevoPunto); // Cambia el método a clasificar

        System.out.println("El nuevo punto pertenece a la clase: " + clasePredicha);

        // Mostrar distancias de los vecinos más cercanos
        List<PuntoDistancia> distancias = knn.calcularDistancias(nuevoPunto);
        System.out.println("Distancias de los vecinos más cercanos:");
        for (PuntoDistancia pd : distancias) {
            System.out.println("Clase: " + pd.getPunto().getEtiqueta() + ", Distancia: " + pd.getDistancia());
        }

        // Evaluar el modelo
        List<Punto> conjuntoPrueba = new ArrayList<>();
        // Cargar datos de prueba (reemplaza con tus datos reales)
        conjuntoPrueba.add(new Punto(1, 90, 70, 20, 50, 30, 0.5, 30, "0"));
        conjuntoPrueba.add(new Punto(0, 85, 66, 29, 0, 26.6, 0.351, 31, "1"));
        // Añade más puntos de prueba según sea necesario

        double precision = knn.evaluarModelo(conjuntoPrueba);
        System.out.println("Precisión del modelo: " + (precision * 100) + "%");
    }
}