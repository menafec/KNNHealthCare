public class Punto {
    private double pregnancies;
    private double glucose;
    private double bloodPressure;
    private double skinThickness;
    private double insulin;
    private double bmi;
    private double diabetesPedigreeFunction;
    private double age;
    private String etiqueta; // La clase del punto (0 o 1)

    public Punto(double pregnancies, double glucose, double bloodPressure, double skinThickness,
                 double insulin, double bmi, double diabetesPedigreeFunction, double age, String etiqueta) {
        this.pregnancies = pregnancies;
        this.glucose = glucose;
        this.bloodPressure = bloodPressure;
        this.skinThickness = skinThickness;
        this.insulin = insulin;
        this.bmi = bmi;
        this.diabetesPedigreeFunction = diabetesPedigreeFunction;
        this.age = age;
        this.etiqueta = etiqueta;
    }

    // Método para calcular la distancia entre dos puntos
    public double calcularDistancia(Punto otro) {
        return Math.sqrt(Math.pow(otro.pregnancies - this.pregnancies, 2) +
                         Math.pow(otro.glucose - this.glucose, 2) +
                         Math.pow(otro.bloodPressure - this.bloodPressure, 2) +
                         Math.pow(otro.skinThickness - this.skinThickness, 2) +
                         Math.pow(otro.insulin - this.insulin, 2) +
                         Math.pow(otro.bmi - this.bmi, 2) +
                         Math.pow(otro.diabetesPedigreeFunction - this.diabetesPedigreeFunction, 2) +
                         Math.pow(otro.age - this.age, 2));
    }

    // Getters
    public double getPregnancies() {
        return pregnancies;
    }

    public double getGlucose() {
        return glucose;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public double getSkinThickness() {
        return skinThickness;
    }

    public double getInsulin() {
        return insulin;
    }

    public double getBmi() {
        return bmi;
    }

    public double getDiabetesPedigreeFunction() {
        return diabetesPedigreeFunction;
    }

    public double getAge() {
        return age;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}