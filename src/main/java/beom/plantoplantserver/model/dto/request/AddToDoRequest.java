package beom.plantoplantserver.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddToDoRequest {

    String id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;

    String toDo;

    Boolean toDoVisibilityCalendar;

}
