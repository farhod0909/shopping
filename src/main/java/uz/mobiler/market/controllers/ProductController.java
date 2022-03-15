package uz.mobiler.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mobiler.market.dto.CategoryDto;
import uz.mobiler.market.dto.CategoryForm;
import uz.mobiler.market.dto.ProductDto;
import uz.mobiler.market.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<ProductDto> findAll(){
        return service.findAllL();
    }

    @GetMapping("/{id}")
    public ProductDto findOne(@PathVariable Long id){
        return service.findOne(id);
    }

    @PostMapping
    public ProductDto add(@RequestBody ProductDto dto){
        return service.add(dto);
    }

    @PutMapping("/{id}")
    public ProductDto update(@RequestBody ProductDto dto, @PathVariable Long id){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
