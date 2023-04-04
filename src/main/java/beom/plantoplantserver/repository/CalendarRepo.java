package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.Calender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepo extends JpaRepository<Calender, Integer> {
}
