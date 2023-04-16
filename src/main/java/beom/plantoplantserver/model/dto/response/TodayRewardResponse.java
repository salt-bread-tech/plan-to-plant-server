package beom.plantoplantserver.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class TodayRewardResponse {

    int totalCount;
    Map<Integer, Integer> plantObtained;

    public TodayRewardResponse() {
        totalCount = 0;
        plantObtained = new HashMap<>();
    }

}
