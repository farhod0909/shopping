package uz.mobiler.market.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.mobiler.market.dto.CategoryDto;
import uz.mobiler.market.dto.CategoryForm;
import uz.mobiler.market.entity.Category;
import uz.mobiler.market.repository.CategoryRepository;
import uz.mobiler.market.service.CategoryService;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public CategoryDto add(CategoryForm form) {
        Category category = new Category();
        category.setName(form.getName());
        if (form.getParentId() != null) {
            Category parent = get(form.getParentId());
            category.setParentCategory(parent);
        }
        return CategoryDto.toDto(repository.save(category));
    }

    @Override
    public CategoryDto update(Long id, CategoryForm form) {
        Category category = get(id);
        category.setName(form.getName());
        if (form.getParentId() != null) {
            Category parent = get(form.getParentId());
            category.setParentCategory(parent);
        }

        return CategoryDto.toDto(repository.save(category));
    }

    @Override
    public CategoryDto findOne(Long id) {
        return CategoryDto.toDto(get(id));
    }


    @Override
    public ResponseEntity findAll() {
        return ResponseEntity.ok(repository.findAllByDeletedFalse()
                .stream()
                .map(CategoryDto::toDto)
                .collect(Collectors.toList()));
    }

    @Override
    public void delete(Long id) {
        Category category = get(id);
        category.setDeleted(true);
        repository.save(category);
    }

    private Category get(Long id){
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new RuntimeException("Category not found!"));
    }


}
