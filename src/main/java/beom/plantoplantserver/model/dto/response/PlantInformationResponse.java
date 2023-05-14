package beom.plantoplantserver.model.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PlantInformationResponse {
    private int id;
    private String name;
    private String description;
}
