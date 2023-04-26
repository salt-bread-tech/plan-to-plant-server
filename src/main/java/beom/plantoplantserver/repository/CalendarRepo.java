package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CalendarRepo extends JpaRepository<Calendar, Integer> {

    List<Calendar> findByUserIdAndDateBetweenAndToDoVisibilityCalendarIsTrue(String user_id, LocalDate start, LocalDate end);
    List<Calendar> findByUserIdAndDate(String user_id, LocalDate date);
    List<Calendar> findByDateAndToDoCompletedIsTrue(LocalDate date);
}
