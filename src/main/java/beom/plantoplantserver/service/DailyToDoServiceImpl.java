package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.CalendarRequest;
import beom.plantoplantserver.repository.CalendarRepo;
import beom.plantoplantserver.model.entity.Calendar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyToDoServiceImpl implements DailyToDoService{

    private final CalendarRepo calendarRepo;

    @Override
    public List<Calendar> getToDoForToday() {
        LocalDate now = LocalDate.now();
        return calendarRepo.findByDate(now);
    }

    @Override
    public List<Calendar> getToDoForDate(CalendarRequest request) {
        LocalDate date = LocalDate.of(request.getYear(), request.getMonth(), request.getDay());
        return calendarRepo.findByDate(date);
    }
}
