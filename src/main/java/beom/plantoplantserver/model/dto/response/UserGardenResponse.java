package beom.plantoplantserver.model.dto.response;


import beom.plantoplantserver.model.entity.Plant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserGardenResponse {
    private int id;
    private Plant plant;
    private int count;
    private boolean isFound;
}
