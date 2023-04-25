package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.PlantRequest;
import beom.plantoplantserver.model.dto.response.TodayRewardResponse;
import beom.plantoplantserver.model.entity.Plant;

import java.util.List;

public interface PlantService {
    List<Plant> getPlantInfo(String name);
    TodayRewardResponse getTodayReward(PlantRequest request);

}
