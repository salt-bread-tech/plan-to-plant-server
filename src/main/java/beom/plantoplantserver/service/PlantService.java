package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.PlantRequest;
import beom.plantoplantserver.model.dto.response.TodayRewardResponse;
import beom.plantoplantserver.model.entity.Flower;

import java.util.List;

public interface PlantService {
    List<Flower> getFlowerInfo();
    TodayRewardResponse getTodayReward(PlantRequest request);
}
