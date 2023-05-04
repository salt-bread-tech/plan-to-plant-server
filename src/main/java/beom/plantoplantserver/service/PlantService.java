package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.PlantRequest;
import beom.plantoplantserver.model.dto.response.PlantInformationResponse;
import beom.plantoplantserver.model.dto.response.TodayRewardResponse;
import beom.plantoplantserver.model.entity.Plant;

import java.util.List;

public interface PlantService {
    PlantInformationResponse getPlantInfo(String name);
    TodayRewardResponse getTodayReward(PlantRequest request);
}
