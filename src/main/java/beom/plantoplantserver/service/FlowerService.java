package beom.plantoplantserver.service;

import beom.plantoplantserver.model.entity.Flower;

import java.util.List;
import java.util.Optional;

public interface FlowerService {
    Optional<Flower> getFlowerInfo(Integer id);
}
