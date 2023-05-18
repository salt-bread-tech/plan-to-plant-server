package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.CalendarRequest;
import beom.plantoplantserver.model.dto.response.UserCalendarResponse;
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
    public List<UserCalendarResponse> getAllToDo(String user_id) {
        List<UserCalendarResponse> userCalendarResponses = calendarRepo.findByUserId(user_id);
        List<UserCalendarResponse> res = new ArrayList<>();
        for (UserCalendarResponse u : userCalendarResponses){
            res.add(UserCalendarResponse.builder()
                    .id(u.getId())
                    .date(u.getDate())
                    .toDo(u.getToDo())
                    .toDoCompleted(u.getToDoCompleted())
                    .build());
        }
        return res;
    }
}
