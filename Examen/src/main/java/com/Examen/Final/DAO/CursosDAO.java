package com.Examen.Final.DAO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cursos", schema = "public")
public class CursosDAO {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long id;
    @Column(name = "nombre_curso")
    private String nombre_curso;
    @Column(name = "profesor")
    private String profesor;
    @OneToMany(mappedBy = "curso")
    private List<InscripcionesDAO> inscripciones;

    public CursosDAO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public CursosDAO(Long id, String nombre_curso, String profesor) {
        this.id = id;
        this.nombre_curso = nombre_curso;
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "CursosDAO{" +
                "id=" + id +
                ", nombre_curso='" + nombre_curso + '\'' +
                ", profesor='" + profesor + '\'' +
                '}';
    }
}
