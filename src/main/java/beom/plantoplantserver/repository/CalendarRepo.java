package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

public interface CalendarRepo extends JpaRepository<Calendar, Integer> {
    List<Calendar> findByDateBetweenAndToDoVisibilityCalenderIsTrue(LocalDate start, LocalDate end);
}
