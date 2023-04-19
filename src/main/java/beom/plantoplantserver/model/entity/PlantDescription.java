package beom.plantoplantserver.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PlantDescription {
    TEST1("test용 꽃"),
    TEST2("test용 꽃2"),
    TEST3("test용 꽃3"),
    TEST4("test용 꽃4"),
    TEST5("test용 꽃5"),
    TEST6("test용 꽃6")
    ;
    private final String description;

    PlantDescription(String description){
        this.description = description;
    }

    public static PlantDescription fromCode(String dbData){
        return Arrays.stream(PlantDescription.values())
                .filter(v -> v.getDescription().equals(dbData))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("식물 설명에 %s 가 존재하지 않습니다.", dbData)));
    }
}
