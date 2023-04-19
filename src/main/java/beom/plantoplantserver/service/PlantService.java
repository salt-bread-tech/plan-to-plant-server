package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.PlantRequest;
import beom.plantoplantserver.model.dto.response.TodayRewardResponse;
import beom.plantoplantserver.model.entity.Plant;

import java.util.Optional;

public interface PlantService {
    Optional<Plant> getPlantInfo(Integer id);
    TodayRewardResponse getTodayReward(PlantRequest request);
}
