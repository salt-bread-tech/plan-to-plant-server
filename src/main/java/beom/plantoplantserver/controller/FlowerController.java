package beom.plantoplantserver.controller;

import beom.plantoplantserver.model.entity.Flower;
import beom.plantoplantserver.service.FlowerService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flower")
public class FlowerController {

    final FlowerService flowerService;

    public FlowerController(FlowerService flowerService){
        this.flowerService = flowerService;
    }

    @GetMapping("/plants-information")
    public Optional<Flower> getFlowerInfo(@RequestParam("id") Integer id){
        return flowerService.getFlowerInfo(id);
    }
}
