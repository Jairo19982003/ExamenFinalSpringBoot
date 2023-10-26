package com.Examen.Final.DTO;

import com.Examen.Final.DAO.EstudiantesDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository extends JpaRepository<EstudiantesDAO, Long> {

}
