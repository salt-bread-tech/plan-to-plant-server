package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.CalendarRequest;
import beom.plantoplantserver.model.dto.response.UserCalendarResponse;

import java.util.List;

public interface DailyToDoService {
    List<UserCalendarResponse> getAllToDo(String user_id);
}
