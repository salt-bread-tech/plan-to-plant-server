package beom.plantoplantserver.controller;

import beom.plantoplantserver.model.entity.Garden;
import beom.plantoplantserver.service.GardenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/garden")
public class GardenController {

    final GardenService gardenService;

    public GardenController(GardenService gardenService) {
        this.gardenService = gardenService;
    }

    @GetMapping("/user")
    public List<Garden> getPlantByUserId(@RequestParam("user_id") String user_id){
        return gardenService.getPlantByUserId(user_id);
    }
}
