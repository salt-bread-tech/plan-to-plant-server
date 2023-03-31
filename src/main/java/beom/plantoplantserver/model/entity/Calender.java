package beom.plantoplantserver.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "calender")
public class Calender {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "user_id")
    String userId;

    @Column(name = "date")
    LocalDateTime date;

    @Column(name = "to_do")
    String toDo;

    @Column(name = "to_do_visibility_calender")
    Boolean toDoVisibilityCalender;

}
