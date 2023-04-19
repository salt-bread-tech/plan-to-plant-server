package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Plant;
import beom.plantoplantserver.model.entity.Garden;
import beom.plantoplantserver.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardenRepo extends JpaRepository<Garden, Integer> {
    Garden findByUserAndPlant(User user, Plant plant);
}
