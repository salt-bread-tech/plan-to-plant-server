package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.CalendarRequest;
import beom.plantoplantserver.model.dto.response.UserCalendarResponse;
import beom.plantoplantserver.model.entity.Calendar;

import java.util.List;

public interface DailyToDoService {
    List<UserCalendarResponse> getToDoForToday(String user_id);
    List<UserCalendarResponse> getToDoForDate(CalendarRequest request);
}
