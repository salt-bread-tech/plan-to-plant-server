package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.PlantReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlantRewardRepo extends JpaRepository<PlantReward, Integer> {

    List<PlantReward> findByUserIdAndIsGotTrue(String userId);

    List<PlantReward> findByUserIdAndIsGotFalse(String userId);

    @Transactional
    void deleteByUserIdAndIsGotFalse(String userId);
}
