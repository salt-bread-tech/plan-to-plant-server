package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.GetPlant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GetPlantRepo extends JpaRepository<GetPlant, Integer> {
}
