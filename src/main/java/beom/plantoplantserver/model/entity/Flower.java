package beom.plantoplantserver.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "flower")
public class Flower {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name ="name")
    String name;

    @Column(name = "percentage")
    String percentage;

    @Column(name = "description")
    String description;

}
