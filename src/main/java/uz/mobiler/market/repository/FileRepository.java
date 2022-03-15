package uz.mobiler.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.mobiler.market.entity.Category;
import uz.mobiler.market.entity.MyFileEntity;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends JpaRepository<MyFileEntity, Long> {
    Optional<MyFileEntity> findByUidAndDeletedFalse(String uid);
    Boolean existsByUid(String uid);
}
