package beom.plantoplantserver.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "garden")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Garden {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "user_id")
    String userId;

    @Column(name = "flower_id")
    int flowerId;

    @Column(name = "count")
    int count;

    @Column(name = "is_found")
    boolean isFound;

}
