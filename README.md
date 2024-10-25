# Predicción de Diabetes con KNN en Java

## Descripción del Proyecto

Este proyecto, diseñado para la materia de Machine Learning, tiene como objetivo predecir si un paciente tiene diabetes utilizando el algoritmo K-Nearest Neighbors (KNN). El modelo se basa en un conjunto de datos proporcionado por el NIDDK (National Institute of Diabetes and Digestive and Kidney Diseases) que incluye varias variables médicas predictivas.

## Dataset

El dataset contiene varias variables predictivas y una variable objetivo (Outcome). Las variables predictivas incluyen:

- **Pregnancies**: Número de veces que la paciente ha estado embarazada.
- **Glucose**: Concentración de glucosa plasmática en una prueba de tolerancia a la glucosa oral.
- **BloodPressure**: Presión arterial diastólica (mm Hg).
- **SkinThickness**: Grosor del pliegue cutáneo tricipital (mm).
- **Insulin**: Insulina sérica a las dos horas.
- **BMI**: Índice de masa corporal.
- **DiabetesPedigreeFunction**: Función del pedigree diabético.
- **Age**: Edad en años.
- **Outcome**: Variable de clase (0 o 1).

### Información del Dataset

- **Total de instancias**: 768
- **Instancias con diabetes (1)**: 268
- **Instancias sin diabetes (0)**: 500

### Consideraciones sobre los Datos

Los valores cero en ciertas columnas (Glucose, BloodPressure, SkinThickness, Insulin, BMI) indican datos faltantes y deben ser tratados adecuadamente.

## Requisitos

- Java JDK (versión 8 o superior)
- Un IDE como Eclipse o IntelliJ IDEA, o un editor de texto como Visual Studio Code
- Conocimientos básicos de Java

## Estructura del Proyecto

El proyecto contiene las siguientes clases:

- **Main**: Clase principal que lee el dataset, entrena el modelo y clasifica nuevos puntos.
- **KNN**: Implementación del algoritmo KNN.
- **Punto**: Representa una instancia del dataset con sus respectivas características.
- **PuntoDistancia**: Clase auxiliar que almacena la relación entre un punto y su distancia.

## Ejemplo de Uso

La clase `Main` incluye un ejemplo de cómo clasificar un nuevo punto utilizando el modelo KNN. Puedes ajustar los valores del nuevo punto en el código para probar diferentes escenarios.

## Evaluación del Modelo

El código también incluye una función para evaluar la precisión del modelo utilizando un conjunto de prueba. Puedes añadir más puntos de prueba para verificar el rendimiento del modelo.

**Fecha:** 25 de octubre de 2024  
**Autora:** Ximena Carolina Fernandez Cardenas
