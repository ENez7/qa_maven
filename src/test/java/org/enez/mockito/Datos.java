package org.enez.mockito;

import org.enez.mockito.models.Examen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Datos {
    static List<Examen> EXAMENES = Arrays.asList(
            new Examen(1L, "Programacion"),
            new Examen(2L, "Calculo"),
            new Examen(3L, "Estructura de datos"),
            new Examen(4L, "Data analytics"),
            new Examen(5L, "Python")
    );

    static List<Examen> EMPTY_EXAM = Collections.emptyList();

    static List<String> PREGUNTAS = Arrays.asList(
            "Secuenciales",
            "Condicionales",
            "Bucles",
            "Vectores"
    );
}
