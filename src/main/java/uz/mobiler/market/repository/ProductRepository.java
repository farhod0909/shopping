package uz.mobiler.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.mobiler.market.entity.Category;
import uz.mobiler.market.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
        List<Product> findAllByDeletedFalse();
        Optional<Product> findByIdAndDeletedFalse(Long id);
}
