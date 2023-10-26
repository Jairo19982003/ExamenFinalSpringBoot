package com.Examen.Final.controller;

import com.Examen.Final.DAO.CursosDAO;
import com.Examen.Final.DTO.CursoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursosController {
    private final CursoRepository CursosRepository;

    public CursosController(CursoRepository CursosRepository) {
        this.CursosRepository = CursosRepository;
    }

    @GetMapping()
    public List<CursosDAO> listar() {
        return CursosRepository.findAll();
    }

    @PostMapping()
    public CursosDAO crear(CursosDAO curso) {
        return CursosRepository.save(curso);
    }

    @PutMapping("/{id}")
    public CursosDAO actualizar(@PathVariable Long id, CursosDAO curso) {
        return CursosRepository.findById(id)
                .map(cursoActualizado -> {
                    cursoActualizado.setNombre_curso(curso.getNombre_curso());
                    cursoActualizado.setProfesor(curso.getProfesor());
                    return CursosRepository.save(cursoActualizado);
                })
                .orElseGet(() -> {
                    curso.setId(id);
                    return CursosRepository.save(curso);
                });


    }
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        CursosRepository.deleteById(id);
    }
}
