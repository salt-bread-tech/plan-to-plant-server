package beom.plantoplantserver.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "calendar")
public class Calendar {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "date")
    LocalDate date;

    @Column(name = "to_do")
    String toDo;

    @Column(name = "to_do_visibility_calendar")
    Boolean toDoVisibilityCalendar;

    @Column(name = "to_do_completed")
    Boolean toDoCompleted;
}
