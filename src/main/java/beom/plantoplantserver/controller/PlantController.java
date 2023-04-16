package beom.plantoplantserver.controller;

import beom.plantoplantserver.model.dto.request.PlantRequest;
import beom.plantoplantserver.model.dto.response.TodayRewardResponse;
import beom.plantoplantserver.service.PlantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
