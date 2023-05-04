package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.CalendarRequest;
import beom.plantoplantserver.model.dto.response.UserCalendarResponse;
import beom.plantoplantserver.model.entity.Calendar;
import beom.plantoplantserver.repository.CalendarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService{

    private final CalendarRepo calendarRepo;

    @Override
    public List<UserCalendarResponse> getToDoForMonth(CalendarRequest request){
        LocalDate startDate = LocalDate.of(request.getYear(), request.getMonth(), 1);
        LocalDate endDate = LocalDate.of(request.getYear(), request.getMonth(), startDate.lengthOfMonth());
        String user_id = request.getUser_id();

        return getUserCalendar(user_id, startDate, endDate);
    }

    @Override
    public List<UserCalendarResponse> getToDoForNowMonth(String user_id){
        LocalDate nowDate = LocalDate.now();
        LocalDate startDate = nowDate.withDayOfMonth(1);
        LocalDate endDate = nowDate.withDayOfMonth(nowDate.lengthOfMonth());

        return getUserCalendar(user_id, startDate, endDate);
    }

    private List<UserCalendarResponse> getUserCalendar(String user_id, LocalDate startDate, LocalDate endDate) {
        List<UserCalendarResponse> userCalendarResponses =
                calendarRepo.findByUserIdAndDateBetweenAndToDoVisibilityCalendarIsTrue(user_id, startDate, endDate);
        List<UserCalendarResponse> resUserCalendarResponses = new ArrayList<>();
        for(UserCalendarResponse c: userCalendarResponses){
            resUserCalendarResponses.add(UserCalendarResponse.builder()
                    .id(c.getId())
                    .date(c.getDate())
                    .toDo(c.getToDo())
                    .toDoCompleted(c.getToDoCompleted())
                    .build());
        }
        return resUserCalendarResponses;
    }
}
