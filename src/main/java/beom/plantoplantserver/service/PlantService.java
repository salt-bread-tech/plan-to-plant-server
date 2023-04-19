package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.PlantRequest;
import beom.plantoplantserver.model.dto.response.TodayRewardResponse;

public interface PlantService {
    TodayRewardResponse getTodayReward(PlantRequest request);
}
