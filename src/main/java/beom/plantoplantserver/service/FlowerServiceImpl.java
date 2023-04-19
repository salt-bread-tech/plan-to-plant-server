package beom.plantoplantserver.service;

import beom.plantoplantserver.model.entity.Flower;
import beom.plantoplantserver.repository.FlowerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlowerServiceImpl implements FlowerService{

    private final FlowerRepo flowerRepo;

    @Override
    public List<Flower> getFlowerInfo() {
        return flowerRepo.findById();
    }
}
