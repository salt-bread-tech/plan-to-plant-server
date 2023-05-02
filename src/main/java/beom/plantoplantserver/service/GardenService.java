package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.response.PlantInformationResponse;
import beom.plantoplantserver.model.dto.response.UserGardenResponse;
import beom.plantoplantserver.model.entity.Garden;

import java.util.List;
import java.util.Optional;

public interface GardenService {
    List<UserGardenResponse> getPlantByUserId(String user_id);
}
