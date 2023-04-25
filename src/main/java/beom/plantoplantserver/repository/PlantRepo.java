package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepo extends JpaRepository<Plant, Integer> {
    List<Plant> getDescriptionByName(String name);
}
