package org.enez.mockito;

import org.enez.mockito.models.Examen;
import org.enez.mockito.repositories.IExamenRepository;
import org.enez.mockito.repositories.IPreguntasRepository;
import org.enez.mockito.services.ExamenServiceImpl;
import org.enez.mockito.services.IExamenService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;


public class ExamenServiceImplTest {
    @Mock
    IExamenRepository examenRepository;
    @Mock
    IPreguntasRepository preguntasRepository;
//    IExamenService service;
    @InjectMocks
    ExamenServiceImpl service;

    @BeforeEach
    void setUp() {
//        examenRepository = Mockito.mock(IExamenRepository.class);
//        preguntasRepository = Mockito.mock(IPreguntasRepository.class);
//        service = new ExamenServiceImpl(examenRepository, preguntasRepository);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findExamenByName() {

        Mockito.when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);

        // prueba unitaria con junit
        Optional<Examen> examen = service.findExamenByName("Programacion");

//        assertNotNull(examen);
        assertTrue(examen.isPresent());
        assertEquals(1L, examen.get().getId());
        assertEquals("Programacion", examen.get().getName());
    }

    @Test
    void findExamenByNameEmptyList() {
        Mockito.when(examenRepository.findAll()).thenReturn(Datos.EMPTY_EXAM);

        Optional<Examen> examen = service.findExamenByName("Programacion");

        assertFalse(examen.isPresent());
    }

    @Test
    void testEncontrarExamenConPreguntas() {
        Mockito.when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        Mockito.when(preguntasRepository.findQuestionsByExamId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.fullExamByName("Programacion");

        assertEquals(4, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("Bucles"));
        verify(examenRepository).findAll();
        verify(preguntasRepository).findQuestionsByExamId(anyLong());
    }
}
