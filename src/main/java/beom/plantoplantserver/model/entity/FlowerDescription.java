package beom.plantoplantserver.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FlowerDescription {
    TEST1("test용 꽃"),
    TEST2("test용 꽃2"),
    TEST3("test용 꽃3"),
    TEST4("test용 꽃4"),
    TEST5("test용 꽃5"),
    TEST6("희귀 꽃");

    private final String description;
}
