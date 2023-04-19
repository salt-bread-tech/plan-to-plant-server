package beom.plantoplantserver.controller;

import beom.plantoplantserver.model.dto.request.PlantRequest;
import beom.plantoplantserver.model.dto.response.TodayRewardResponse;
import beom.plantoplantserver.model.entity.Plant;
import beom.plantoplantserver.service.PlantService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/plant")
public class PlantController {

    final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping("/today-reward")
    public TodayRewardResponse getTodayReward(@RequestBody PlantRequest request) {
        return plantService.getTodayReward(request);
    }

    @GetMapping("/plants-information")
    public Optional<Plant> getFlowerInfo(@RequestParam("id") Integer id){
        return plantService.getPlantInfo(id);
    }

}
