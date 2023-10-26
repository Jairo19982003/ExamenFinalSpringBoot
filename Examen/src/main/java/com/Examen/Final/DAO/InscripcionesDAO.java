package com.Examen.Final.DAO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inscripciones", schema = "public")
public class InscripcionesDAO {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Long id_inscripcion;
    @Column(name = "id_estudiante")
    private Long id_estudiante;
    @Column(name = "id_curso")
    private Long id_curso;
    @Column(name = "fecha_inscripcion")
    private Date fecha_inscripcion;
    @ManyToOne
    @JoinColumn(name = "id_estudiante", insertable = false, updatable = false)
    private EstudiantesDAO estudiante;
    @ManyToOne
    @JoinColumn(name = "id_curso", insertable = false, updatable = false)
    private CursosDAO curso;

    public InscripcionesDAO() {

    }

    public Long getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(Long id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public Long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public InscripcionesDAO(Long id_inscripcion, Long id_estudiante, Long id_curso, Date fecha_inscripcion) {
        this.id_inscripcion = id_inscripcion;
        this.id_estudiante = id_estudiante;
        this.id_curso = id_curso;
        this.fecha_inscripcion = fecha_inscripcion;
    }
}
