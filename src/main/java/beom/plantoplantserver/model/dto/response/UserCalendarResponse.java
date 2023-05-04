package beom.plantoplantserver.model.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class UserCalendarResponse {
    private int id;
    private LocalDate date;
    private String toDo;
    private Boolean toDoCompleted;
}
