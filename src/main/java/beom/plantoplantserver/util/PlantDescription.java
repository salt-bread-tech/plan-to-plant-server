package beom.plantoplantserver.util;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PlantDescription {
    // PlantEnum
    // ENUM을 사용해서 데이터베이스에 저장할 수 있도록 수정
    // ID 똑같으면 Update, 새로운 ID면 Insert 실행하도록
    // Find 방식 -> Insert 방식으로 변경 必
    TEST1("test용 꽃"),
    TEST2("test용 꽃2"),
    TEST3("test용 꽃3"),
    TEST4("test용 꽃4"),
    TEST5("test용 꽃5"),
    TEST6("test용 꽃6")
    //LILY(1, "lily", 0.03, "설명")
    ;

    /*
    private final Integer id;
    private final String name;
    private final double percentage;
     */
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
