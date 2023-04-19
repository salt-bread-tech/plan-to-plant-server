package beom.plantoplantserver.controller;

import beom.plantoplantserver.model.entity.Flower;
import beom.plantoplantserver.service.FlowerService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/plants-information/{id}")
    public Optional<Flower> getFlowerInfo(@PathVariable Integer id){
        return flowerService.getFlowerInfo(id);
    }
}
