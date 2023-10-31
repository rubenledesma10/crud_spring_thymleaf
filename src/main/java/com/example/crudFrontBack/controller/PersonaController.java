
package com.example.crudFrontBack.controller;

import com.example.crudFrontBack.model.Persona;
import com.example.crudFrontBack.service.IPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaController {
    
    @Autowired
    private IPersonasService persoServ;
    
    @GetMapping({"/personas","/"})
    public String personas(Model modelo, @Param("palabraClave") String palabraClave){ //esto es para indicarle que vamos a pasarle un paramentro
        
        modelo.addAttribute("personas", persoServ.getPersona(palabraClave));
        modelo.addAttribute("palabraClave", palabraClave);
        return "index";
    }
    
    @GetMapping("/personas/nueva")
    public String nuevaPersonaForm (Model modelo){
        Persona personas = new Persona();
        modelo.addAttribute("personas", personas);
        return "nuevaPersona";
    }
    
    @PostMapping("/personas")
    public String crearPersona(@ModelAttribute ("persona") Persona personas){ //este atributo es el objeto que recibimos del formulario
        persoServ.crearPersona(personas);
        return "redirect:/personas";
    }
    
    @GetMapping("/personas/{id_persona}")
    public String eliminarPersona(@PathVariable Long id_persona){
        persoServ.deletePersona(id_persona);
        return "redirect:/personas";
    }
    
    @GetMapping("/personas/editar/{id_persona}")
    public String mostrarPersonaEditar(@PathVariable Long id_persona, Model modelo){
        modelo.addAttribute("persona", persoServ.findPersona(id_persona));
        return "editarPersona";
    }
    
    @PostMapping("/personas/{id_persona}")
    public String editarPersona(@PathVariable Long id_persona, @ModelAttribute("persona") Persona persona, Model modelo){
        Persona persoEditar = persoServ.findPersona(id_persona);
        persoEditar.setApellido(persona.getApellido());
        persoEditar.setDni(persona.getDni());
        persoEditar.setNombre(persona.getNombre());
        persoEditar.setTelefono(persona.getTelefono());
        persoEditar.setEmail(persona.getEmail());
        persoServ.editPersona(persoEditar);
        return "redirect:/personas";
    }
    
}
