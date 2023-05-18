package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.dto.response.UserCalendarResponse;
import beom.plantoplantserver.model.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CalendarRepo extends JpaRepository<Calendar, Integer> {

    List<UserCalendarResponse> findByUserIdAndDateBetweenAndToDoVisibilityCalendarIsTrue(String user_id
            , LocalDate start, LocalDate end);
    List<Calendar> findByDateAndToDoCompletedIsTrue(LocalDate date);
    List<UserCalendarResponse> findByUserId(String user_id);
}
