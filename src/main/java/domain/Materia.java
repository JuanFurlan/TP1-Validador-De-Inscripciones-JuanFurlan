package domain;

import java.util.List;
public class Materia {
    private Integer codigo;
    private String nombre;
    public List<Materia> correlativas;


    public Materia(Integer codigo, List<Materia> correlativas, String nombre) {
        this.codigo = codigo;
        this.correlativas = correlativas;
        this.nombre = nombre;
    }
}
