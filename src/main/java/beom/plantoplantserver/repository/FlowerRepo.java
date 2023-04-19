package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlowerRepo extends JpaRepository<Flower, Integer> {
    Optional<Flower> findById(Integer id);
}
