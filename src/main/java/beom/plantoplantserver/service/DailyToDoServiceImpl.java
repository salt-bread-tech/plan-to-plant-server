package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.CalendarRequest;
import beom.plantoplantserver.repository.CalendarRepo;
import beom.plantoplantserver.model.entity.Calendar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyToDoServiceImpl implements DailyToDoService{

    private final CalendarRepo calendarRepo;

    @Override
    public List<Calendar> getToDoForToday(String user_id) {
        LocalDate now = LocalDate.now();

        return getUserDailyToDo(user_id, now);
    }

    @Override
    public List<Calendar> getToDoForDate(CalendarRequest request) {
        LocalDate date = LocalDate.of(request.getYear(), request.getMonth(), request.getDay());
        String uId = request.getUser_id();

        return getUserDailyToDo(uId, date);
    }

    private List<Calendar> getUserDailyToDo(String user_id, LocalDate now){
        List<Calendar> calendars = calendarRepo.findByUserIdAndDate(user_id, now);
        List<Calendar> resCalendars = new ArrayList<>();
        for(Calendar c : calendars){
            resCalendars.add(Calendar.builder()
                    .id(c.getId())
                    .date(c.getDate())
                    .toDo(c.getToDo())
                    .toDoCompleted(c.getToDoCompleted())
                    .build());
        }
        return resCalendars;
    }
}
