package org.enez.mockito.repositories;

import org.enez.mockito.models.Examen;

import java.util.List;

public interface IExamenRepository {
    Examen guardar(Examen examen);
    List<Examen> findAll();
}
