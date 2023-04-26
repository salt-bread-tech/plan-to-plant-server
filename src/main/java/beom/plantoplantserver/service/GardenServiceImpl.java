package beom.plantoplantserver.service;

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
    public List<Garden> getPlantByUserId(String user_id) {
        return getPlantList(user_id);
    }

    private List<Garden> getPlantList(String user_id){
        List<Garden> gardens = gardenRepo.findByUserId(user_id);
        List<Garden> resGardens = new ArrayList<>();

        for(Garden g : gardens){
            resGardens.add(Garden.builder()
                    .id(g.getId())
                    .plant(g.getPlant())
                    .count(g.getCount())
                    .isFound(g.isFound())
                    .build());
        }
        return resGardens;
    }
}
