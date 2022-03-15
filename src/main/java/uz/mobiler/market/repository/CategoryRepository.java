package uz.mobiler.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.mobiler.market.entity.BaseEntity;
import uz.mobiler.market.entity.Category;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
        List<Category> findAllByDeletedFalse();
        Optional<Category> findByIdAndDeletedFalse(Long id);
}
