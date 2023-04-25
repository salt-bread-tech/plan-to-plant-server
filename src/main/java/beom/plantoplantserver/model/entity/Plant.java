package beom.plantoplantserver.model.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "plant")
public class Plant {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "percentage")
    Double percentage;

    @Column(name = "description")
    @Convert(converter = DescriptionToStringConverter.class)
    PlantDescription description;
}