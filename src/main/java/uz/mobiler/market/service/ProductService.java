package uz.mobiler.market.service;


import uz.mobiler.market.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto add(ProductDto dto);
    ProductDto update(Long id, ProductDto dto);
    ProductDto findOne(Long id);
    List<ProductDto> findAllL();
    void delete(Long id);
}
