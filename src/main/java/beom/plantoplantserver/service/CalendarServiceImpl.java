package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.CalendarRequest;
import beom.plantoplantserver.model.dto.request.RegisterRequest;
import beom.plantoplantserver.model.entity.Calendar;
import beom.plantoplantserver.repository.CalendarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService{

    private final CalendarRepo calendarRepo;

    @Override
    public List<Calendar> getToDoForMonth(CalendarRequest request){
        LocalDate startDate = LocalDate.of(request.getYear(), request.getMonth(), 1);
        LocalDate endDate = LocalDate.of(request.getYear(), request.getMonth(), startDate.lengthOfMonth());
        return calendarRepo.findByDateBetweenAndToDoVisibilityCalendarIsTrue(startDate, endDate);
    }

    @Override
    public List<Calendar> getToDoForNowMonth(){
        LocalDate nowDate = LocalDate.now();
        LocalDate startDate = nowDate.withDayOfMonth(1);
        LocalDate endDate = nowDate.withDayOfMonth(nowDate.lengthOfMonth());
        return calendarRepo.findByDateBetweenAndToDoVisibilityCalendarIsTrue(startDate, endDate);
    }
}
