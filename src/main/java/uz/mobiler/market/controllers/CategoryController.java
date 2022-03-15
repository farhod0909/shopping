package uz.mobiler.market.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mobiler.market.dto.CategoryDto;
import uz.mobiler.market.dto.CategoryForm;
import uz.mobiler.market.service.CategoryService;


@RestController
@RequestMapping("/api/v1/category")
 class CategoryController {
    private final CategoryService service;

    CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto findOne(@PathVariable Long id){
        return service.findOne(id);
    }

    @PostMapping
    public CategoryDto add(@RequestBody CategoryForm form){
        return service.add(form);
    }
    @PutMapping("/{id}")
    public CategoryDto update(@RequestBody CategoryForm form, @PathVariable Long id){
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         service.delete(id);
    }

}
