package com.Examen.Final.DTO;

import com.Examen.Final.DAO.InscripcionesDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionesRepository extends JpaRepository<InscripcionesDAO, Long>{

}
