package uz.mobiler.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.mobiler.market.entity.Product;
import uz.mobiler.market.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUsernameAndDeletedFalse(String username);
}
