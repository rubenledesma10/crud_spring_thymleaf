
package com.example.crudFrontBack.repository;

import com.example.crudFrontBack.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository <Persona, Long>{
    
    //esto es para el buscador en la pagina
    @Query ("SELECT p FROM Persona p WHERE"
            + " CONCAT(p.id, p.nombre, p.apellido, p.dni, p.telefono, p.email)"
            + " LIKE %?1%") //con esto le indicamos que vamos a buscar el producto por su nombre
    public List<Persona> findAll(String palabraClave);
    
}
