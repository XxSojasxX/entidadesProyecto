package com.trackit.entities.category;

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
@RequestMapping("/trackit/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    //Create
    @PostMapping
    public Category categorySave(@RequestBody Category entity)
    {
        return categoryService.categorySave(entity);
    }

    //Select
    @GetMapping("/{id}/")
    public Category categoryFindById(@PathVariable Long id)
    {
        return categoryService.categoryFindById(id);
    }

    //SelectAll
    @GetMapping
    public List<Category> categoryFindAll()
    {
        return categoryService.categoryFindAll();
    }

    //Update
    @PutMapping("/update/{id}/")
    public Category categoryUpdate(@RequestBody	Category entity)
    {
        return categoryService.categorySave(entity);
    }

    //Delete
    @DeleteMapping("/{id}/")
    public void categoryDelete(@PathVariable Long id)
    {
        categoryService.categoryDeleteById(id);
    }
}
