package org.enez.mockito.services;
import java.util.List;
import java.util.Optional;

import org.enez.mockito.models.Examen;
import org.enez.mockito.repositories.IExamenRepository;
import org.enez.mockito.repositories.IPreguntasRepository;


public class ExamenServiceImpl implements IExamenService {
    private IExamenRepository iExamenRepository;
    private IPreguntasRepository iPreguntasRepository;
    // Dependency injection
    public ExamenServiceImpl(IExamenRepository iExamenRepository, IPreguntasRepository iPreguntasRepository) {
        this.iExamenRepository = iExamenRepository;
        this.iPreguntasRepository = iPreguntasRepository;
    }

    @Override
    public Optional<Examen> findExamenByName(String name) {
         return iExamenRepository.findAll()
                .stream()
                .filter(examen -> examen.getName().contains(name))
                .findFirst();
    }

    @Override
    public Examen fullExamByName(String name) {
        Optional<Examen> optionalExamen = findExamenByName(name);
        Examen examen = null;
        if(optionalExamen.isPresent()) {
            examen = optionalExamen.orElseThrow();
            List<String> questions = iPreguntasRepository
                    .findQuestionsByExamId(examen.getId());
            examen.setPreguntas(questions);
        }
        return examen;
    }

    @Override
    public Examen guardar(Examen examen) {
        if( !examen.getPreguntas().isEmpty())
            iPreguntasRepository.guardarVarias(examen.getPreguntas());
        return iExamenRepository.guardar(examen);
    }
}
