package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.response.UserGardenResponse;
import beom.plantoplantserver.model.entity.Garden;
import beom.plantoplantserver.repository.GardenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService{

    private final GardenRepo gardenRepo;

    @Override
    public List<UserGardenResponse> getPlantByUserId(String user_id) {
        return getPlantList(user_id);
    }

    private List<UserGardenResponse> getPlantList(String user_id){
        List<Garden> gardens = gardenRepo.findByUserId(user_id);
        List<UserGardenResponse> resUserGardens = new ArrayList<>();

        for(Garden g : gardens){
            resUserGardens.add(UserGardenResponse.builder()
                    .id(g.getId())
                    .plantName(g.getPlant().getName())
                    .count(g.getCount())
                    .isFound(g.isFound())
                    .build());
        }
        return resUserGardens;
    }
}
