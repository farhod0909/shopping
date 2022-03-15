package uz.mobiler.market.service;

import org.springframework.http.ResponseEntity;
import uz.mobiler.market.dto.CategoryDto;
import uz.mobiler.market.dto.CategoryForm;

public interface CategoryService {
    CategoryDto add(CategoryForm form);

    CategoryDto update(Long id, CategoryForm form);

    CategoryDto findOne(Long id);

    ResponseEntity findAll();

    void delete(Long id);
}
