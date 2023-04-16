package beom.plantoplantserver.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "garden")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Garden {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "flower_id")
    Flower flower;

    @Column(name = "count")
    int count;

    @Column(name = "is_found")
    boolean isFound;

}
