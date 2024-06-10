package com.trackit.entities.area;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trackit/areas")
public class AreaControler {
    
    @Autowired
    private AreaService areaService;

    //Create
    @PostMapping
    public Area areaSave (@RequestBody Area entity)
    {
        return areaService.areaSave(entity);
    }

    //Select
    @GetMapping("/{id}/")
    public Area areaFindById(@PathVariable Long id)
    {
        return areaService.areaFindById(id);
    }

    //Select All

    @GetMapping
    public List<Area> areaFindAll()
    {
        return areaService.areaFindAll();
    }

    //Update
    @PutMapping("/update/{id}/")
    public Area areaUpdate(@RequestBody Area entity)
    {
        return areaService.areaSave(entity);
    }

    //Delete
    @DeleteMapping("/{id}/")
    public void areaDelete(@PathVariable Long id)
    {
        areaService.areaDeleteById(id);
    }

}
