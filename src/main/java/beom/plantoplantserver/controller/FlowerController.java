package beom.plantoplantserver.controller;

import beom.plantoplantserver.model.entity.Flower;
import beom.plantoplantserver.service.FlowerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {

    final FlowerService flowerService;

    public FlowerController(FlowerService flowerService){
        this.flowerService = flowerService;
    }

    @GetMapping("/plant-informations")
    public List<Flower> getFlowerInfo(){
        return flowerService.getFlowerInfo();
    }
}
