package uz.mobiler.market.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.mobiler.market.dto.ProductDto;
import uz.mobiler.market.entity.Category;
import uz.mobiler.market.entity.Product;
import uz.mobiler.market.repository.FileRepository;
import uz.mobiler.market.repository.ProductRepository;
import uz.mobiler.market.service.ProductService;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final FileRepository fileRepository;
    private final EntityManager manager;

    @Override
    public ProductDto add(ProductDto dto) {
        Product product = fillProduct(dto, new Product());
        repository.save(product);
        return ProductDto.toDto(product);
    }

    @Override
    public ProductDto update(Long id, ProductDto dto) {
        return ProductDto.toDto(repository.save(fillProduct(dto, get(id))));
    }

    @Override
    public ProductDto findOne(Long id) {
        return ProductDto.toDto(get(id));
    }

    @Override
    public List<ProductDto> findAllL() {
        return repository.findAllByDeletedFalse().stream().map(ProductDto::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Product product = get(id);
        product.setDeleted(true);
        repository.save(product);
    }

    private Product get(Long id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new RuntimeException("Product not found with: " + id));
    }

    private Product fillProduct(ProductDto dto, Product e) {
        if (!fileRepository.existsByUid(dto.getPhotoUid()))
            throw new RuntimeException("File not found by uid: "+ dto.getPhotoUid());
        e.setName(dto.getName());
        e.setPrice(dto.getPrice());
        e.setPhotoUid(dto.getPhotoUid());
        e.setCategory(manager.getReference(Category.class, dto.getCategoryId()));
        return e;
    }
}
