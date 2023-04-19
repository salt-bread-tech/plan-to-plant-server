package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlantRepo extends JpaRepository<Plant, Integer> {
    Optional<Plant> findById(Integer id);
}
