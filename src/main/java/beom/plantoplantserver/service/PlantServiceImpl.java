package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.PlantRequest;
import beom.plantoplantserver.model.dto.response.TodayRewardResponse;
import beom.plantoplantserver.model.entity.Flower;
import beom.plantoplantserver.model.entity.Garden;
import beom.plantoplantserver.model.entity.PlantReward;
import beom.plantoplantserver.repository.FlowerRepo;
import beom.plantoplantserver.repository.GardenRepo;
import beom.plantoplantserver.repository.PlantRewardRepo;
import beom.plantoplantserver.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService{

    private final PlantRewardRepo plantRewardRepo;
    private final GardenRepo gardenRepo;
    private final FlowerRepo flowerRepo;

    @Override
    public TodayRewardResponse getTodayReward(PlantRequest request) {
        TodayRewardResponse result = new TodayRewardResponse();
        Map<Integer, Integer> countObtained = new HashMap<>();
        boolean isSuccess = false;

        // 받지 않은 보상 목록 가져오기
        List<PlantReward> plantRewards = plantRewardRepo.findByUserIdAndIsGotFalse(request.getId());

        // 도감에 보상 추가
        isSuccess = addToGarden(plantRewards);

        // 결과 전달
        if (!isSuccess) {
            result.setTotalCount(0);
            result.setPlantObtained(null);
            System.out.println("식물 지급 실패");
        }
        else {
            // 지급 수, 지급된 식물 id와 수 전달
            result.setTotalCount(plantRewards.size());
            for (PlantReward p : plantRewards) countObtained.put(p.getId(), p.getCount());
            result.setPlantObtained(countObtained);
            System.out.println("식물 지급 성공");

            // 지급한 데이터 삭제
            plantRewardRepo.deleteByUserIdAndIsGotTrue(request.getId());
            System.out.println("지급한 데이터 삭제 완료");
        }

        return result;
    }

    @Override
    public List<Flower> getFlowerInfo() {
        return flowerRepo.findById();
    }

    private boolean addToGarden(List<PlantReward> plantRewards) {
        boolean b = false;

        if (plantRewards.size() == 0) b = false;
        else {
            for (PlantReward p : plantRewards) {
                Garden g = gardenRepo.findByUserAndFlower(p.getUser(), p.getFlower());

                if (!g.isFound()) g.setFound(true); // 획득했으므로 변경
                g.setCount(g.getCount() + p.getCount()); // 수량 변경
                gardenRepo.save(g);

                p.setIsGot(true);   // 획득한 데이터 true 로 변경
                plantRewardRepo.save(p);
            }

            b = true;
        }

        return b;
    }
}
