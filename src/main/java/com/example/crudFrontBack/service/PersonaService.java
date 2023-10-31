
package com.example.crudFrontBack.service;

import com.example.crudFrontBack.model.Persona;
import com.example.crudFrontBack.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonasService {

    @Autowired 
    private IPersonaRepository persoRepo;
    
    @Override
    public void crearPersona(Persona perso) {
        persoRepo.save(perso);
    }

    @Override
    public List<Persona> getPersona(String palabraClave) {
        if(palabraClave != null){
            return persoRepo.findAll(palabraClave);
        }
        return persoRepo.findAll();
    }

    @Override
    public Persona findPersona(Long id_persona) {
        return persoRepo.findById(id_persona).orElse(null);
    }

    @Override
    public void deletePersona(Long id_persona) {
        persoRepo.deleteById(id_persona);
    }

    @Override
    public void editPersona(Persona perso) {
        this.crearPersona(perso);
    }
    
}
