package beom.plantoplantserver.service;

import beom.plantoplantserver.model.entity.Garden;

import java.util.List;
import java.util.Optional;

public interface GardenService {
    List<Garden> getPlantByUserId(String user_id);
}
