package beom.plantoplantserver.service;

import beom.plantoplantserver.model.entity.Flower;
import beom.plantoplantserver.repository.FlowerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlowerServiceImpl implements FlowerService{

    private final FlowerRepo flowerRepo;

    @Override
    public Optional<Flower> getFlowerInfo(Integer id) {
        return flowerRepo.findById(id);
    }
}
