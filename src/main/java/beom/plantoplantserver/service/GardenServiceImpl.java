package beom.plantoplantserver.service;

import beom.plantoplantserver.model.entity.Garden;
import beom.plantoplantserver.repository.GardenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService{

    private final GardenRepo gardenRepo;

    @Override
    public List<Garden> getPlantByUserId(String user_id) {
        return gardenRepo.findByUserId(user_id);
    }
}
