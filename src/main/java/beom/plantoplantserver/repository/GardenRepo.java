package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Garden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardenRepo extends JpaRepository<Garden, Integer> {
}
