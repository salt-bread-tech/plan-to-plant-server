package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowerRepo extends JpaRepository<Flower, Integer> {
    List<Flower> findAll();
}
