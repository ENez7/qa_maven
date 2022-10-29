package org.enez.mockito.repositories;

import org.enez.mockito.models.Examen;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExamenRepositoryImpl implements IExamenRepository{
    @Override
    public List<Examen> findAll() {
//        return Arrays.asList(
//                new Examen(1L, "Programacion"),
//                new Examen(2L, "Calculo"),
//                new Examen(3L, "Estructura de datos"),
//                new Examen(4L, "Data analytics"),
//                new Examen(5L, "Python")
//        );

        return Collections.emptyList();
    }
}
