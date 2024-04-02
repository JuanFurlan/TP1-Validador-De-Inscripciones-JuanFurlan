package domain;

import java.util.List;

public class Inscripcion {
    private Integer nroInscripcion;
    private Alumno alumno;
    private List<Materia> materiasAInscribirse;

    public Inscripcion(Integer nroInscripcion, Alumno alumno, List <Materia> materiasAInscribirse){
        this.nroInscripcion = nroInscripcion;
        this.alumno = alumno;
        this.materiasAInscribirse = materiasAInscribirse;
    }
    public boolean aprobada() {
        for (Materia materia : materiasAInscribirse) {
            if (!alumno.materiasAprobadas.containsAll(materia.correlativas)) {
                return false;
            }
        }
        return true;
    }
}
