package beom.plantoplantserver.model.entity;

import beom.plantoplantserver.util.PlantDescription;
import beom.plantoplantserver.util.DescriptionToStringConverter;
import lombok.*;

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