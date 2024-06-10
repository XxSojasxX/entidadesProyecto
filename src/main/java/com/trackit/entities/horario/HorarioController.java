package com.trackit.entities.horario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/trackit/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    //Create
    @PostMapping
    public Horario horarioSave (@RequestBody Horario entity)
    {
        return horarioService.horarioSave(entity);
    }

    //Select
    @GetMapping("/{id}/")
    public Horario horarioFindById(@PathVariable Long id)
    {
        return horarioService.horarioFindById(id);
    }

    //Select All
    @GetMapping
    public List<Horario> horarioFindAll()
    {
        return horarioService.horarioFindAll();
    }

    //Update
    @PutMapping("/update/{id}/")
    public ResponseEntity<Horario> horarioUpdate(@PathVariable Long id, @RequestBody Horario updatedHorario) {
        Horario existingHorario = horarioService.horarioFindById(id);
        if (existingHorario != null) {
            existingHorario.setNombreHorario(updatedHorario.getNombreHorario());
            existingHorario.setHoraInicio(updatedHorario.getHoraInicio());
            existingHorario.setHoraEntrada(updatedHorario.getHoraEntrada());
            // Actualizar otros campos según sea necesario

            return ResponseEntity.ok(horarioService.horarioSave(existingHorario));
        } else {
            throw new EntityNotFoundException("Horario with id " + id + " not found");
        }
    }                              
    
    //Delete
    @DeleteMapping("/{id}/")
        public void horarioDelete(@PathVariable Long id)
        {
            horarioService.horarioDeleteById(id);
        }
    
    
}
