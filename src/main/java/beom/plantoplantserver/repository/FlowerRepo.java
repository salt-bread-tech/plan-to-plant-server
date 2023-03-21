package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepo extends JpaRepository<Flower, Integer> {
}
