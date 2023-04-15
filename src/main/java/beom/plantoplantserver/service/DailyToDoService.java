package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.CalendarRequest;
import beom.plantoplantserver.model.entity.Calendar;

import java.util.List;

public interface DailyToDoService {
    List<Calendar> getToDoForToday();
    List<Calendar> getToDoForDate(CalendarRequest request);
}
