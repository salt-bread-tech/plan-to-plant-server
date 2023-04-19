package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Plant;
import beom.plantoplantserver.model.entity.PlantDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlantRepo extends JpaRepository<Plant, Integer> {
    List<Plant> getDescriptionByName(String name);
}
