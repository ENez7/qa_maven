package org.enez.mockito.services;

import org.enez.mockito.models.Examen;

import java.util.Optional;

public interface IExamenService {
    Optional<Examen> findExamenByName(String name);
    Examen fullExamByName(String name);
    Examen guardar(Examen examen);
}
