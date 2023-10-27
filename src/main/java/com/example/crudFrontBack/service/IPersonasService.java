
package com.example.crudFrontBack.service;

import com.example.crudFrontBack.model.Persona;
import java.util.List;

public interface IPersonasService {
    
    //crear
    public void crearPersona(Persona perso);
    
    //traer todos
    public List<Persona> getPersona();
    
    //traer traer un solo objeto
    public Persona findPersona(Long id_persona);
    
    //eliminar
    public void deletePersona(Long id_persona);
    
    //editar
    public void editPersona(Persona perso);
    
}
