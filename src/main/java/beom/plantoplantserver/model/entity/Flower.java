package beom.plantoplantserver.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "flower")
public class Flower{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "percentage")
    Double percentage;

    @Column(name = "description")
    //@Convert(converter = descriptionToStringConverter.class)
    String description;
}