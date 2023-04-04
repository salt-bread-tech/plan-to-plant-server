package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepo extends JpaRepository<Calendar, Integer> {
}
