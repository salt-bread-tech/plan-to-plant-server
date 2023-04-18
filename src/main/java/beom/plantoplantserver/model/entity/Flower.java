package beom.plantoplantserver.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "flower")
@Builder
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
    @Enumerated(EnumType.STRING)
    FlowerDescription description;
}
