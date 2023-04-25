package beom.plantoplantserver.scheduler;

import beom.plantoplantserver.model.entity.Calendar;
import beom.plantoplantserver.repository.CalendarRepo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class PlantScheduler {

    private final CalendarRepo calendarRepo;

    public PlantScheduler(CalendarRepo calendarRepo) {
        this.calendarRepo = calendarRepo;
    }

    @Scheduled(cron = "0 0 6 * * *")
    public void acquirePlants() {
        printStart();

        LocalDate now = LocalDate.now();
        LocalDate targetDay = now.minusDays(1);
        List<Calendar> calendarList = calendarRepo.findByDateAndToDoCompletedIsTrue(targetDay);

        for (Calendar c : calendarList) {
            
        }
    }

    private void printStart() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
        String nowString = now.format(dateTimeFormatter);
        System.out.println(nowString + "  스케줄 시작");
    }

}
