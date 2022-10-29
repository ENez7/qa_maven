package org.enez.mockito.repositories;

import java.util.List;

public interface IPreguntasRepository {
    void guardarVarias(List<String> preguntas);
    List<String> findQuestionsByExamId(Long id);
}
