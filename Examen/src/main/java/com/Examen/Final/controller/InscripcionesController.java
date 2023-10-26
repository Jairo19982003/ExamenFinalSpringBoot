package com.Examen.Final.controller;


import com.Examen.Final.DAO.InscripcionesDAO;
import com.Examen.Final.DTO.InscripcionesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionesController {
    private final InscripcionesRepository  InscripcionesRepository;

    public InscripcionesController(InscripcionesRepository InscripcionesRepository) {
            this.InscripcionesRepository = InscripcionesRepository;
        }

        @GetMapping()
        public List<InscripcionesDAO> listar() {
            return InscripcionesRepository.findAll();
        }

        @PostMapping()
        public InscripcionesDAO crear(InscripcionesDAO Inscripciones) {
            return InscripcionesRepository.save(Inscripciones);
    }


}


