package com.Examen.Final.controller;

import com.Examen.Final.DAO.EstudiantesDAO;
import com.Examen.Final.DTO.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    private final CrudRepository crudRepository;

    public EstudianteController(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @GetMapping()
    public List<EstudiantesDAO> listar() {
        return crudRepository.findAll();
    }

    @PostMapping
    public EstudiantesDAO crear(EstudiantesDAO estudiante) {
        return crudRepository.save(estudiante);
    }

    @PutMapping("/{id}")
    public EstudiantesDAO actualizar(@PathVariable Long id, EstudiantesDAO estudiante) {
        return crudRepository.findById(id)
                .map(estudianteActualizado -> {
                    estudianteActualizado.setNombre(estudiante.getNombre());
                    estudianteActualizado.setApellido(estudiante.getApellido());
                    estudianteActualizado.setEmail(estudiante.getEmail());
                    return crudRepository.save(estudianteActualizado);
                })
                .orElseGet(() -> {
                    estudiante.setId(id);
                    return crudRepository.save(estudiante);
                });
    }


    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        crudRepository.deleteById(id);
    }

}
