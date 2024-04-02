package domain;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class InscripcionTest {

    private final Materia paradigmas;
    private final Materia sintaxis;
    private final Materia ads;
    private final Materia disenio;
    private final Materia fisica2;
    private final Materia tadp;
    private final Materia gestion;



    public InscripcionTest() {
        paradigmas = new Materia(1000, new ArrayList<>(), "Paradigmas De la Programacion");
        sintaxis = new Materia(2000, new ArrayList<>(), "Sintaxis Y Semantica de la Programacion ");
        ads = new Materia(3000, new ArrayList<>(), "Analisis de Sistemas");
        fisica2 = new Materia(4000, new ArrayList<>(), "Fisica II");
        tadp = new Materia(5000, new ArrayList<>(), "Tecnicas Avanzadas de Programacion");
        gestion = new Materia(5000, new ArrayList<>(), "Gestion de Datos");
        disenio = new Materia(4000, Arrays.asList(paradigmas, sintaxis, ads), "Diseño de Sistemas");


    }

    private Alumno crearAlumnoConMateriasAprobadas(Materia... materias) {
        return new Alumno("176.227-8", "Juan Manuel Furlan Hermida", Arrays.asList(materias));
    }

    @Test
    public void testTieneTodasLasCorrelativasAprobadas() {
        Integer nroInscripcion = 1001;
        Alumno alumno = crearAlumnoConMateriasAprobadas(paradigmas, sintaxis, ads);
        List<Materia> materiasAInscribirse = Arrays.asList(tadp, fisica2, gestion, disenio);


        Inscripcion inscripcion = new Inscripcion(nroInscripcion, alumno, materiasAInscribirse);

        boolean resultado = inscripcion.aprobada();
        assertTrue(resultado);
    }

    @Test
    public void testNoTieneTodasLasCorrelativasAprobadas() {
        Integer nroInscripcion = 1001;
        Alumno alumno = crearAlumnoConMateriasAprobadas(paradigmas, sintaxis);
        List<Materia> materiasAInscribirse = Arrays.asList(tadp, fisica2, gestion, disenio);

        Inscripcion inscripcion = new Inscripcion(nroInscripcion, alumno, materiasAInscribirse);

        boolean resultado = inscripcion.aprobada();
        assertFalse(resultado);
    }
}